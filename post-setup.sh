#!/usr/bin/env bash
USAGE="$0 <post_title>"
if [ $# -lt 1 ]; then echo -e "ERROR: post_title required. \n$USAGE" >&2; exit 1; fi
if [ $# -gt 1 ]; then echo -e "ERROR: One argument maximum.\n$USAGE" >&2; exit 1; fi

POST_TITLE=${1:?"POST_TITLE Parameter is missing!"}
echo "Post title : $POST_TITLE"

mkdir ${POST_TITLE}
touch ${POST_TITLE}/README.adoc
cp -r template/* ${POST_TITLE}
sed -i "s/template/${POST_TITLE}/g" ${POST_TITLE}/settings.gradle
cp template/.gitignore ${POST_TITLE}/.gitignore
