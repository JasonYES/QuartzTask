#! /bin/bash

pgrep -f "com.jd.dbw.App" | xargs -i kill -9 {}