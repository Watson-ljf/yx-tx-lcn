#!/usr/bin/env bash
# 发布生产版本
mvn clean deploy  -Dmaven.test.skip -pl yx-tm -P release