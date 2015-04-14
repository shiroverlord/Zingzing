module.exports = function(grunt) {
	//imports
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-ng-annotate');
	grunt.loadNpmTasks('grunt-contrib-watch')
	
	// Configuration de Grunt
	grunt.initConfig({
		concat: {
			options: {
				separator: ';', // permet d'ajouter un point-virgule entre chaque fichier concat�n�.
			},
			dist: {
				src: ['app/app.js', 'app/views.js', 'app/**/*.js'], // la source
				dest: 'app/application.js' // la destination finale
			}
		},
		ngAnnotate: {
            options: {
                singleQuotes: true
            },
            dist: {
                files: {
                    '<%= concat.dist.dest %>': ['<%= concat.dist.dest %>']
                }
            }
        },
		uglify: {
			dist: {
                    '<%= concat.dist.dest %>': ['<%= concat.dist.dest %>']
                }
		},
		watch: {
			scripts: {
				files: ['app/app.js', 'app/views.js', 'app/**/*.js'], // surveille les fichiers � compiler
				tasks: ['concat:dist', 'ngAnnotate:dist']
		  }
		}
	})
	
	  // D�finition des t�ches Grunt
	//grunt.registerTask('default', ['concat:dist', 'ngAnnotate:dist', 'uglify:dist'])
	grunt.registerTask('default', ['dev', 'watch'])
	grunt.registerTask('dev', ['concat:dist', 'ngAnnotate:dist'])	//,'ngAnnotate:dist'
	grunt.registerTask('dist', ['concat:dist', 'ngAnnotate:dist', 'uglify:dist'])	//,'ngAnnotate:dist'

}