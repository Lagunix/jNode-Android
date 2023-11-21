**Termux/Android edition**

Features:
- synchronous interface is used

Known problems:
- sucessfull send via loopback interface under non-rooted  Android-13+ devices ONLY if receive packets in the same session (you must create any request to your node from your Android FTN-client like HotDoged before poll node)

How to install:
- install Termux
- pkg update && pkg upgrade
- pkg install openjdk-17 (optional, if not installed)
- pkg install maven
- pkg install git
- pkg install mc (optional)
- git clone https://github.com/Lagunix/jnode.git
- cd jnode
- mvn install -Dmaven.test.skip=true
- cd .m2/repository/jnode/jnode-assembly/1.5
- unzip jnode-assembly-1.5-**dev** /jnode/
- cd jnode 
- edit ./etc/jnode.nix.conf
- cp ./etc/jnode.nix.conf jnode.conf
- cd ./bin
- chmod +x run.sh
- note: run.sh use only bash!
- run.sh
- enjoy!

Also, you can istall jnode under Termux/proot-distro as the same, but keep attention about free memory, strongly recommends at least 6Gb RAM or more.

Regards to https://github.com/hssergey !

=== /end Termux edition readme

**jNode** is a complex portable application, providing all necessary functions (mailer, tosser, tracker) for a FTN system.

It's written in Java (version 1.8 recommended) and distributed under the terms of Apache License 2.0.

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

