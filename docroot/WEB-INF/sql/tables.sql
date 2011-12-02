create table msc_Instance (
	InstanceId LONG not null primary key,
	name VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	lastModifiedDate DATE null
);

create table msc_Location (
	locationId LONG not null primary key,
	address VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	imageId LONG,
	imageURL VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null
);