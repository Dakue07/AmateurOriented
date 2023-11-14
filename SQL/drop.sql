# autocommitの切断

BEGIN;


# データベースの選択

CONNECT orcl


# 初期化のためのテーブル削除 基本的にはoracleと変更はないが
# cascadeが意味をなさないのとIF EXISTS(存在していたら削除)は異なる点。

DROP TABLE IF EXISTS REVIEWTABLE;
DROP TABLE IF EXISTS ORDERDETAILSTABLE;
DROP TABLE IF EXISTS ORDERTABLE;
DROP TABLE IF EXISTS CARTTABLE;
DROP TABLE IF EXISTS CARDTABLE;
DROP TABLE IF EXISTS USERADDRESSTABLE;
DROP TABLE IF EXISTS RICETABLE;
DROP TABLE IF EXISTS USERTABLE;


# 管理ユーザーに接続しなおし。

quit
mysql -u root -p
comecomeshoppass


# autocommit切断

BEGIN;


# comeユーザーの削除

DROP USER come;