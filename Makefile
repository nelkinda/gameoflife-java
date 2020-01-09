SONAR_USERNAME?=admin
SONAR_PASSWORD?=admin
SONAR_PORT?=9000
SONAR_HOST?=http://localhost:$(SONAR_PORT)/

.PHONY: all
all:
	./mvnw package

.PHONY: mutation
mutation:
	./mvnw -q clean test org.pitest:pitest-maven:mutationCoverage

.PHONY: sonar
sonar:
	./mvnw verify sonar:sonar -Dsonar.host.uri="$(SONAR_HOST)" -Dsonar.login="$(SONAR_USERNAME)" -Dsonar.password="$(SONAR_PASSWORD)"

.PHONY: sonard
sonard:
	docker run -d --name sonarqube -p $(SONAR_PORT):9000 sonarqube

.PHONY: clean
clean:
	./mvnw clean

-include User.mk
