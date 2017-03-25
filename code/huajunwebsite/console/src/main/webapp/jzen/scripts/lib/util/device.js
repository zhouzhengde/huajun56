define(['underscore'], function (_) {

    var platform = navigator.platform;
    var web = [
        'win',
        'mac',
        'linux',
        'unix'
    ];
    return {

        isMobile: function () {
            var isWEB = false;
            if (platform) {
                var v = platform.toLowerCase();
                _.each(web, function (m) {
                    if (v.indexOf(m) >= 0) {
                        isWEB = true;
                    }
                });
            }
            return !isWEB;
        }
    }
});