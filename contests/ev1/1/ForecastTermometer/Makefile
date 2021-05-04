SRC=$(wildcard *.java)
MAIN=Solution
CLASS=$(patsubst %.java, %.class, $(SRC))
CC=javac
IC=java

compile:
	@$(CC) $(SRC)

clean:
	rm $(CLASS)

t:
	@set -e ; \
	for input in ./inputs/*.in; do \
		output=$$(echo $$input | sed -re 's/\.in$$/.out/' | sed -re 's/inputs/outputs/') ;\
		res=$$(echo $$input | sed -re 's/\.in$$/.res/' | sed -re 's/inputs/res/') ; \
		diff=$$(echo $$input | sed -re 's/\.in$$/.diff/' | sed -re 's/inputs/diffs/') ; \
		mkdir -p "./res" ;\
		mkdir -p "./diffs" ;\
		echo ; \
		echo "Test on $$input: " ; \
		$(IC) $(MAIN) < "$$input" > "$$res" ;\
		if git diff --no-index $$res $$output > $$diff; then \
			echo "OK" ;\
		else \
			echo "FAIL" ;\
		fi ;\
	done



test: compile t clean


all_test: compile t
