pipelineJob("pipeline_dsl_test") {
	description()
	keepDependencies(false)
	definition {
		cpsScm {
"""pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                shell("docker build -t test .")
            }
        }
        stage('deploy') {
            steps {
                shell("docker stop test || true && docker rm test || true")
                shell("docker run --restart always --net=host --name test --detach -p 5000:5000 test")
                shell("sleep 5")
            }
        }
        stage('test'){
            steps {
                shell("if [ \\\$(curl -s http://127.0.0.1:5000/api/hello | grep Hello | wc -l) != 1 ]; then \\
                    exit 1 \\
                fi")
            }
        }
    }
}"""		}
	}
	disabled(false)
	configure {
		it / 'properties' / 'jenkins.model.BuildDiscarderProperty' {
			strategy {
				'daysToKeep'('7')
				'numToKeep'('-1')
				'artifactDaysToKeep'('-1')
				'artifactNumToKeep'('-1')
			}
		}
		it / 'properties' / 'com.coravy.hudson.plugins.github.GithubProjectProperty' {
			'projectUrl'('https://github.com/zazer3000/test/')
			displayName()
		}
	}
}
