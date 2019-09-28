.PHONY: all
all:
	./mvnw package

.PHONY: clean
clean:
	./mvnw clean

-include User.mk
