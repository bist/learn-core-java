#!/bin/sh

# --- Command line
refname="$1"
oldrev="$2"
newrev="$3"

# --- Safety check
if [ -z "$GIT_DIR" ]; then
	echo "Don't run this script from the command line." >&2
	echo " (if you want, you could supply GIT_DIR then run" >&2
	echo "  $0 <ref> <oldrev> <newrev>)" >&2
	exit 1
fi

if [ -z "$refname" -o -z "$oldrev" -o -z "$newrev" ]; then
	echo "usage: $0 <ref> <oldrev> <newrev>" >&2
	exit 1
fi

if [[ $refname =~ master$ ]]; then
	echo "Running tests ..."
	temp_dir=`uuidgen`
	mkdir -p /tmp/assignments/$temp_dir
	git archive $newrev | tar -x -C /tmp/assignments/$temp_dir
	cd /tmp/assignments/$temp_dir && mvn test > output
	total=`egrep -m 1 -o "Tests run:.*Skipped: [0-9]+" output | cut -d: -f2 | cut -d, -f1`
	failed=`egrep -m 1 -o "Tests run:.*Skipped: [0-9]+" output | cut -d: -f3 | cut -d, -f1`
	errors=`egrep -m 1 -o "Tests run:.*Skipped: [0-9]+" output | cut -d: -f4 | cut -d, -f1`
	skipped=`egrep -m 1 -o "Tests run:.*Skipped: [0-9]+" output | cut -d: -f5 | cut -d, -f1`
	echo "Total number of tests: $total"
	echo "Total number of failures: $failed"
	echo "Total number of errors: $errors"
	echo "Total number of skipped: $skipped"
	score=`echo "(($total - $failed - $skipped - $errors) / $total) * 100" | bc -l | cut -d. -f1`
	echo "================================================"
	echo "             YOUR SCORE IS: $score              "
	echo "================================================"
	exit 1
fi

echo "This repo is not for check-in. It is just for scoring your assignments!"
exit 1
