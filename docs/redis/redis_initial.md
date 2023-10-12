# install
```bash
sudo apt update
sudo apt install redis-server
sudo nano /etc/redis/redis.conf
```

or  user data to create launch template  
```bash 
#!/bin/bash

# Update packages and install Redis server
apt update
apt install -y redis-server awscli

# Set Redis password
sed -i 's/# requirepass foobared/requirepass pwd/' /etc/redis/redis.conf

# Enable Redis to listen on all interfaces
sed -i 's/bind 127.0.0.1/bind 0.0.0.0/' /etc/redis/redis.conf

# Restart Redis service
systemctl restart redis-server

```

```bash
bind 0.0.0.0
# requirepass foobared
requirepass ""
sudo systemctl restart redis-server
redis-cli ping
redis-cli INFO server
```

# test
```bash
redis-cli --scan --pattern '*'
systemctl status redis

redis-cli monitor

redis-cli
config set requirepass pwd
save
exit

redis-cli -a pwd --scan --pattern '*'

```
![](../img/redis_initial-20230927.png)
![](../img/redis_initial-20230927-1.png)
![](../img/redis_initial-20230927-2.png)

```bash
ubuntu@ip-:~$ redis-cli -a pwd --scan --pattern '*'
Warning: Using a password with '-a' or '-u' option on the command line interface may not be safe.
topic:Household Junk
quiz_id:test
quiz_id:3
topic:Garden Waste
topic:Recycled Waste
quiz_id:2
quiz_id:1

ubuntu@ip-:~$ redis-cli -a pwd
Warning: Using a password with '-a' or '-u' option on the command line interface may not be safe.
127.0.0.1:6379> SMEMBERS "topic:Recycled Waste"
1) "test"
2) "3"

```


# backup redis
```bash
ubuntu@ip-3:~$ redis-cli -a pwd
Warning: Using a password with '-a' or '-u' option on the command line interface may not be safe.
Warning: AUTH failed
127.0.0.1:6379> --raw BGSAVE
(error) ERR unknown command `--raw`, with args beginning with: `BGSAVE`, 
127.0.0.1:6379> BGSAVE
Background saving started
127.0.0.1:6379> CONFIG GET dir
1) "dir"
2) "/var/lib/redis"
```

# transfer data
```bash
ubuntu@ip-:~$ sudo aws configure
AWS Access Key ID [None]: xx
AWS Secret Access Key [None]: xx
Default region name [None]: xx
Default output format [None]: 

ubuntu@ip-172-31-82-173:~$ sudo aws s3 cp /var/lib/redis/dump.rdb s3://xx/dump.rdb
upload: ../../var/lib/redis/dump.rdb to s3://caxx/dump.rdb
```

# import data
[Import and export data | Redis Documentation Center](https://docs.redis.com/latest/rs/databases/import-export/)  

```bash
aws s3 cp s3://xxx/dump.rdb /home/redis_backup/2023-09-30.rdb

sudo systemctl stop redis-server

sudo rm /var/lib/redis/dump.rdb

sudo mv /home/redis_backup/2023-09-30.rdb /var/lib/redis/dump.rdb

sudo systemctl start redis-server

```