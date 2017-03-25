define([
    '../.md',
    'angular',
    'jquery',
    'underscore',
    'raphael'
], function (md, ng, $, _, raphael) {


    return {
        dom: null,
        paper: null,
        defaultConfig: {
            dom: "body",
            baseFontSize: 14,
            fontFamily: "Vijaya Kozuka Gothic Pr6N EL frutigernext_medium frutigernext \"Microsoft YaHei\" Arial Helvetica sans-serif",
            firstBlockOffset: 90,
            smallBlockOffset: 0,
            data: [],
            title: "Default"
        },
        init: function (config) {

            if (config) {
                for (attr in config) {
                    if (config[attr]) {
                        this.defaultConfig[attr] = config[attr];
                    }
                }
            }

            this.dom = $(this.defaultConfig.dom);
            this.paper = raphael(this.dom.get(0), '100%', '100%');
        },
        utils: {
            path: {
                arc: function (cx, cy, r, large, direct, close) {

                    return 'M' + (direct ? cx - r : cx) + ' '
                        + (direct ? cy : cy - r) + ' a' + r + ' ' + r + ' 1 '
                        + (direct ? '1 ' : '0 ')
                        + (large ? '0 ' : '1 ') + r + ' ' + r
                        + (close ? ' z' : '');

                },
                line: function (x1, y1, x2, y2) {
                    return 'M' + x1 + ' ' + y1 + ' L' + x2 + " " + y2;
                }
            }
        },
        flexFontSize: function (ratio) {
            var width = this.dom.outerWidth();
            if (width < 550) {
                return parseInt(this.defaultConfig.baseFontSize * 0.7 * ratio) + "px";
            }
            return parseInt(this.defaultConfig.baseFontSize * ratio) + "px";
        },
        draw: function () {

            this.clear();

            var animationTime = 550;
            var width = this.dom.outerWidth();
            var height = this.dom.outerHeight();
            var radius = width > height ? height : width;
            var blocks = this.defaultConfig.data.length;
            var baseAngle = Math.PI * 2 / 360;
            var perAngel = 360 / blocks;
            var smallBlocks = [];
            var centerBlockRadius = radius / 6;
            var smallBlockRadius = centerBlockRadius / 2.4;
            var centerText = null;

            var onCenterMouseover = function () {
                if (!centerText) {
                    return
                }
                //centerText.rotate(45);
                centerBlock.animate({
                    r: centerBlockRadius + this.defaultConfig.smallBlockOffset / 1.5
                }, animationTime)

            }.bind(this);
            var onCenterMouseout = function () {
                if (!centerText) {
                    return
                }
                //centerText.rotate(-45);
                centerBlock.animate({
                    r: centerBlockRadius
                }, animationTime)
            }.bind(this);
            var centerBlock = this.paper.circle(width / 2, height / 2, smallBlockRadius * 1.5).attr({
                "fill": "#fa5d43",
                "stroke": "#fa5d43",
                "cursor": "pointer"
            }).animate(raphael.animation({
                r: centerBlockRadius
            }, animationTime).delay(animationTime * blocks + animationTime)).mouseover(onCenterMouseover).mouseout(onCenterMouseout);
            var centerAttr = centerBlock.attr();

            centerText = this.paper.text(centerAttr.cx, centerAttr.cy, this.defaultConfig.title).attr({
                "fill": "#ffffff",
                "stroke": "#ffffff",
                "font-family": this.defaultConfig.fontFamily,
                "font-weight": 300,
                "font-size": this.flexFontSize(2.0),
                "font-style": "italic",
                "cursor": "pointer",
                "opacity": 0,
            }).animate(raphael.animation({
                "opacity": 1,
            }, animationTime).delay(animationTime * blocks + animationTime * 2)).mouseover(onCenterMouseover);
            if (blocks == 0) {
                if (console) {
                    console.error("没有数据结点")
                }
                return;
            }

            // var r = centerBlockRadius;
            // var path = this.utils.path.arc(centerAttr.cx, centerAttr.cy, r * 0.7, false, true);
            // this.paper.path(path).attr({
            //     "stroke": '#fff246',
            //     'stroke-width': 3
            // });

            for (var i = 0; i < blocks; i++) {

                var blockAngle = i * perAngel - this.defaultConfig.firstBlockOffset;
                var blockData = this.defaultConfig.data[i];
                var cx = Math.cos(baseAngle * blockAngle) * (centerBlockRadius + this.defaultConfig.smallBlockOffset) + centerAttr.cx;
                var cy = Math.sin(baseAngle * blockAngle) * (centerBlockRadius + this.defaultConfig.smallBlockOffset) + centerAttr.cy;
                var delay = animationTime * (i + 1);
                var animation = raphael.animation({
                    r: smallBlockRadius,
                    cx: cx,
                    cy: cy,

                }, animationTime, 'liner');

                var block = null;

                var drawContent = function (_block, isHidden) {
                    if (!_block) {
                        return;
                    }
                    var dot = _block.dot;

                    if (_block.line) {

                        if (isHidden) {
                            _block.line.attr({
                                'stroke-width': 0
                            });
                        } else {
                            _block.line.attr({
                                'stroke-width': 1
                            });
                        }
                        return;
                    }

                    var line = this.paper.path(this.utils.path.line(dot.attr().cx, dot.attr().cy, (dot.attr().cx + 100), dot.attr().cy)).attr({
                        "stroke": '#6d33ff',
                        'stroke-width': (isHidden ? 0 : 1)
                    });
                    _block.line = line;

                }.bind(this);

                var dotAnimate = function (block, offset, isHidden) {
                    var dotAngel = 0;
                    if (block.blockAngle >= 90 && block.blockAngle <= 270) {
                        dotAngel = 180;
                    }

                    var dotCx = Math.cos(baseAngle * dotAngel) * (smallBlockRadius + offset) + block.attr().cx;
                    var dotCy = Math.sin(baseAngle * dotAngel) * (smallBlockRadius + offset) + block.attr().cy;
                    var r = 2;

                    if (isHidden) {
                        r = 0;
                        dotCx = block.attr().cx;
                        dotCy = block.attr().cy;
                    }

                    block.dot.animate({
                        r: r,
                        cx: dotCx,
                        cy: dotCy,
                    }, animationTime, 'liner', function () {
                        drawContent(drawContent(block, isHidden));
                    });

                };

                var animateOver = function (block) {
                    block.animate({
                        r: smallBlockRadius + 10
                    }, animationTime);

                    dotAnimate(block, 10);

                };

                var onBlockMouseover = function (event) {
                    animateOver(this);
                };

                var onBlockMouseout = function (event) {
                    this.animate({
                        r: smallBlockRadius
                    }, animationTime);

                    dotAnimate(this, 0, true);
                };
                block = this.paper.circle(
                    centerAttr.cx,
                    centerAttr.cy,
                    smallBlockRadius / 1.5
                ).attr({
                    "fill": "#faae3d",
                    "stroke": "#faae3d",
                    "cursor": "pointer",
                }).animate(animation.delay(delay)).data(blockData).mouseover(onBlockMouseover).mouseout(onBlockMouseout);

                var text = this.paper.text(cx, cy, blockData.text).attr({
                    "fill": blockData.fill || "#ffffff",
                    "stroke": blockData.fill || "#ffffff",
                    "font-family": blockData.fontFamily || this.defaultConfig.fontFamily,
                    "font-weight": "200",
                    "font-size": blockData.fill || this.flexFontSize(1.2),
                    "font-style": blockData.fill || "",
                    "cursor": "pointer",
                    "opacity": 0
                }).animate(raphael.animation({
                    "opacity": 1
                }, animationTime, 'liner').delay(delay + animationTime)).mouseover(function () {
                    animateOver(this.block);
                });

                text.block = block;
                block.blockAngle = blockAngle
                block.text = block;

                var dot = this.paper.circle(cx, cy, 0).attr({
                    r: 0,
                    "fill": "#fa5d43",
                    "stroke": "#fa5d43",
                });

                block.dot = dot;
                smallBlocks.push(block);
            }
        },
        clear: function () {

            this.paper.clear();
        }

    };

});