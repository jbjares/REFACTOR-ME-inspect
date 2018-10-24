.PHONY: all
all:
	docker build --no-cache --pull --rm -t personalhealthtrain/inspect:0.0.1 .

