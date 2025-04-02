job("test2") {
	description()
	keepDependencies(false)
	scm {
		git {
			remote {
				github("zazer3000/test", "https")
			}
			branch("*/main")
		}
	}
	disabled(false)
	triggers {
		githubPush()
	}
	concurrentBuild(false)
	steps {
		shell("""docker build -t test .
docker stop test || true && docker rm test || true
docker run --restart always --net=host --name test --detach -p 5000:5000 test 
sleep 5
if [ \$(curl -s http://127.0.0.1:5000/api/hello | grep Hello | wc -l) != 1 ]; then
	exit 1
fi""")
	}
	wrappers {
		preBuildCleanup {
			deleteDirectories(false)
			cleanupParameter()
		}
		timeout {
			absolute(5)
		}
	}
	configure {
		it / 'properties' / 'jenkins.model.BuildDiscarderProperty' {
			strategy {
				'daysToKeep'('7')
				'numToKeep'('-1')
				'artifactDaysToKeep'('-1')
				'artifactNumToKeep'('-1')
			}
		}
	}
}
