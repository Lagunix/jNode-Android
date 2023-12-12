# jNode-Android

**Android/Termux edition**

[![readthedocs](https://shields.io/readthedocs/jnode-android)](https://jnode-android.readthedocs.io)
[![github/workflow](https://github.com/lagunix/jnode-android/actions/workflows/main.yml/badge.svg)](https://github.com/termux/lagunix/jnode-android/actions)

[![github/downloads](https://shields.io/github/downloads/Lagunix/jNode-Android/total)](https://github.com/Lagunix/jNode-Android/releases)
[![github/downloads/latest](https://shields.io/github/downloads/lagunix/jnode-android/latest/total)](https://github.com/lagunix/jnode-android/releases/latest)
[![github/issues](https://shields.io/github/issues/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/issues)
[![github/issues-closed](https://shields.io/github/issues-closed/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/issues?q=is%3Aissue+is%3Aclosed)
[![github/issues-pr](https://shields.io/github/issues-pr/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/pulls)
[![github/issues-pr-closed](https://shields.io/github/issues-pr-closed/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/pulls?q=is%3Apr+is%3Aclosed)
[![github/discussions](https://shields.io/github/discussions/lagunux/jnode-android)](https://github.com/lagunix/jnode-android/discussions)
[![github/milestones](https://shields.io/github/milestones/all/lagunix/jnode-android)](https://github.com/lafunix/jnode-android/milestones)
[![github/forks](https://shields.io/github/forks/jnode-android)](https://github.com/lagunix/jnode-android/network/members)
[![github/stars](https://shields.io/github/stars/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/stargazers)
[![github/watchers](https://shields.io/github/watchers/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/watchers)
[![github/contributors](https://shields.io/github/contributors/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/graphs/contributors)
[![github/commit-activity](https://shields.io/github/commit-activity/w/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/graphs/commit-activity)
[![github/last-commit](https://shields.io/github/last-commit/jnode-android)](https://github.com/lagunix/jnode-android/commits)
[![github/release-date](https://shields.io/github/release-date/lagunix/jnode-android)](https://github.com/lagunix/jnode-android/releases/latest)

[![github/license](https://shields.io/github/license/jnode-android)](https://github.com/lagunix/jnode-android/LICENSE)
[![github/languages](https://shields.io/github/languages/count/jnode-android)](https://github.com/Lagunix/jNode-Android)
[![github/languages/top](https://shields.io/github/languages/top/jnode-android)](https://github.com/Lagunix/jNode-Android)
[![github/directory-file-count](https://shields.io/github/directory-file-count/lagunux/jnode-android)](https://github.com/lagunix/jnode-android)
[![github/code-size](https://shields.io/github/languages/code-size/lagunix/jnode-android)](https://github.com/lagunix/jnode-android)
[![github/repo-size](https://shields.io/github/repo-size/lagunix/jnode-android)](https://github.com/lagunix/jnode-android)
[![github/v](https://shields.io/github/v/release/lagunix/jnode-android)](https://github.com/lagunix/jnode-android)

[![pypi/status](https://shields.io/pypi/status/jnode-android)](https://pypi.org/project/jnode-android/#description)
[![pypi/v](https://shields.io/pypi/v/jnode-android)](https://pypi.org/project/jnode-android/#history)
[![pypi/downloads](https://shields.io/pypi/dd/jnode-android)](https://pypi.org/project/jnode-android/#files)
[![pypi/format](https://shields.io/pypi/format/jnode-android)](https://pypi.org/project/jnode-android/#files)
[![pypi/implementation](https://shields.io/pypi/implementation/jnode-android)](https://pypi.org/project/jnode-android/#files)
[![pypi/pyversions](https://shields.io/pypi/pyversions/jnode-android)](https://pypi.org/project/jnode-android/#files)

This doesn't support:

- [ ] [Chroot](termux-chroot)
  - [ ] error

```toml
[package_name]
source = "github"
github = "author_name/repo_name"
use_max_tag = true
```
Other features:

- [x] synchronous network interface
- [x] managed from Android interface
- [x] managed from Termux

## Screenshots

### Diagnostic

### Document Link

![document link](https://

### Hover

![keyword](https://

![package](https://

### Completion

![completion](https://

![arch](https://

![license](https://github.com/lagunix/jnode-android/

![depends](https://github.com/lagunix/jnode-android/assets/

## How Does It Work

Read
[![readthedocs](https://shields.io/readthedocs/lagunix/jnode-android)](https://jnode-android.readthedocs.io)
to know more.

Known problems (fixed):
- sucessfull send via loopback interface under non-rooted  Android-13+ devices ONLY if receive packets in the same session (you must create any request to your node from your Android FTN-client like HotDoged before poll node)

How to install:
* install Termux
* install Termux-Widget
* pkg update && pkg upgrade
* pkg install openjdk-17 (optional, if not installed)
* pkg install maven
* pkg install git
* git clone https://github.com/Lagunix/jNode-Android.git
* cd jnode
* mvn install -Dmaven.test.skip=true
* cd .m2/repository/jnode/jnode-android-assembly/1.5
* unzip jnode-android-assembly-1.5-**dev** /jnode/
* cd jnode 
* edit ./etc/jnode.conf
* cd ./bin
* edit TZ (your actual time zone) at top of ./bin/run.sh
* chmod +x run.sh
* note: run.sh use only bash!
* run.sh
* Enjoy!

Also, you can istall jNode under Termux/proot or proot-distro, but in this case, keep attention about free memory, strongly recommends at least 6Gb RAM or more.

Regards to https://github.com/hssergey

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

