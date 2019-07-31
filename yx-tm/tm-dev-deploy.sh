#!/usr/bin/env bash
# 发布开发快照
mvn clean deploy  -Dmaven.test.skip -pl yx-tm -P dev