module.exports = function (grunt) {
    grunt.initConfig({
        // concat: {
        //     options: {}
        //     ,
        //     dist: {
        //         src: [
        //             // 'jzen/scripts/lib/*.js',
        //             'jzen/scripts/lib/require.js',
        //             // 'jzen/scripts/lib/**/**/*.js',
        //             // 'jzen/scripts/lib/**/**/**/*.js',
        //             /*'js/!*.js',
        //              'module/!**!/!*.js',
        //              'module/!**!/!**!/!*.js',*/
        //         ],
        //         dest: 'dist/built-require.js'
        //     }
        // }
        // ,
        uglify: {
            build: {
                src: 'jzen/scripts/lib/require.js',
                dest: 'dist/require.min.js'
            }
        }
        ,
        requirejs: {
            compile: {
                options: {
                    baseUrl: "jzen/scripts/lib",
                    mainConfigFile: "jzen/scripts/lib/config.js",
                    name: "jzen",
                    include: [

                    ],
                    out: "dist/main.min.js",

                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    //grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-requirejs');

    //grunt.registerTask('default', ['requirejs','concat', 'uglify']);
    grunt.registerTask('default', ['requirejs', 'uglify']);
}