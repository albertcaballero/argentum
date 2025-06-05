
SRC_DIR=src
OUT_DIR=out
MAIN_CLASS=com.albert.argentum.Main
JAVAC=javac

SRC=$(shell find $(SRC_DIR) -name "*.java")

all: compile

compile:
	@echo "Compiling Argentum"
	mkdir -p $(OUT_DIR)
	$(JAVAC) -d $(OUT_DIR) $(SRC)

run: compile
	java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)

.PHONY: clean run compile all
