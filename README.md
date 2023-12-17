# jNode-Android

**Android/Termux edition**

<div align="center">

[![Latest release](https://img.shields.io/github/v/release/lagunix/jnode-android?include_prereleases&label=latest%20release&style=for-the-badge)](https://github.com/lagunix/jnode-android/releases/latest)
![Downloads](https://img.shields.io/github/downloads/lagunix/jnode-android/total?style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/lagunix/jnode-android?style=for-the-badge)
[![Code-size](https://shields.io/github/languages/code-size/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg?style=for-the-badge)](https://github.com/lagunix/jnode-android/blob/main/CODE_OF_CONDUCT.md)
[![Languages](https://shields.io/github/languages/count/lagunix/jnode-android?style=for-the-badge)](https://github.com/Lagunix/jNode-Android)
[![Languages/top](https://shields.io/github/languages/top/lagunix/jnode-android?style=for-the-badge)](https://github.com/Lagunix/jNode-Android)
[![Directory-file-count](https://shields.io/github/directory-file-count/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android)
[![LICENSE](https://img.shields.io/github/license/lagunix/jnode-android?color=blue&style=for-the-badge)](https://github.com/lagunix/jnode-android/blob/main/LICENSE)
[![Issues](https://shields.io/github/issues/Lagunix/jNode-Android?style=for-the-badge)](https://github.com/lagunix/jnode-android/issues)
[![Issues-pr](https://shields.io/github/issues-pr/Lagunix/jNode-Android?style=for-the-badge)](https://github.com/lagunix/jnode-android/pulls)
[![Discussions](https://shields.io/github/discussions/Lagunix/jNode-Android?style=for-the-badge)](https://github.com/Lagunix/jNode-Android/discussions)
![Forks](https://shields.io/github/forks/Lagunix/jNode-Android?style=for-the-badges)](https://github.com/lagunix/jnode-android/network/members)
![Stars](https://shields.io/github/stars/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android/stargazers)
![Watchers](https://shields.io/github/watchers/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android/watchers)
![Contributors](https://shields.io/github/contributors/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android/graphs/contributors)
![Commit-activity](https://shields.io/github/commit-activity/w/lagunix/jnode-android?style=for-the-badge)](https://github.com/lagunix/jnode-android/graphs/commit-activity)
![Last-commit](https://shields.io/github/last-commit/Lagunix/jNode-Android?style=for-the-badge)](https://github.com/lagunix/jnode-android/commits)
</div>

This version doesn't support:

- [ ] Chroot (termux-chroot)

Features:

- [x] synchronous network interface
- [x] managed from Android interface
- [x] managed from Termux

## Screenshots

## Completion

## How Does It Work

Read
[![readthedocs](https://shields.io/readthedocs/lagunix/jnode-android)](https://jnode-android.readthedocs.io)
to know more.

### Known problems [fixed]
- [x] sucessfull send via loopback interface under non-rooted Android-13+ devices ONLY if receive packets in the same session (you must create any request to your node from your Android FTN-client like HotDoged before poll node)

## How to install:
* install Termux
* install Termux-Widget
* pkg update && pkg upgrade
* pkg install openjdk-17 (optional, if not installed)
* pkg install git maven
* git clone https://github.com/Lagunix/jNode-Android.git
* cd jnode
* mvn install -Dmaven.test.skip=true
* cd .m2/repository/jnode/jnode-android-assembly/1.5
* unzip jnode-android-assembly-1.5-**dev** ~/jnode/
* cd ~/jnode 
* edit ./etc/jnode.conf
* cd ./bin
* edit TZ (your actual time zone) at top of ./bin/run.sh
* chmod +x run.sh
* note: run.sh use only bash!
* run.sh
* Enjoy!

Also, you can istall jNode under Termux proot or proot-distro pkg, but in this case, keep attention about free memory, strongly recommends at least 6Gb RAM or more.

Regards to https://github.com/hssergey

============

Below is a description of the original JNode project:

**jNode** is a complex portable application, providing all necessary functions (mailer, tosser, tracker) for a FTN system.

It's written in Java and distributed under the terms of Apache License 2.0.

Features of the current version:
- sending and receiving bundles using binkp/1.1-compatible protocol
- keeping all the data (links, messages, subscriptions etc.) in the SQL database
- on-the-fly bundle creation
- multithreading
- netmail routing and tracking
- robots
- fileareas support
- simple AreaFix (`+echo`, `-echo`, `%rescan`, `%list`, `%query`, `%help`)
- simple FileFix (`+fecho`, `-fecho`, `%list`, `%query`, `%help`)

jNode uses the [ORMLite](http://ormlite.com) library for SQL database access, thus supporting DB2, Derby, H2, hSQL, mySQL, Netezza, Oracle, PostgreSQL, SQLite, MS SQL Server.

