
DROP TABLE  IF EXISTS devices;
create table devices
(
	ID BIGINT  auto_increment
		primary key,
	DEVICE_UID VARCHAR(1500)
		unique,
	DEVICE_TYPE VARCHAR(20),
	DEVICE_MODEL VARCHAR(200),
	OS_VERSION VARCHAR(100)

);