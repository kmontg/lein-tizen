#!/bin/sh

set -e

PACKAGE_NAME=lein-tizen.wgt
WGT_DIR=tizen/out
TARGET=w-1217-1

tizen install --name $PACKAGE_NAME \
              --target $TARGET \
              -- $WGT_DIR