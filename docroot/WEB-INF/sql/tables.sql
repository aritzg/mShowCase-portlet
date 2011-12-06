create table msc_Activity (
	activityId LONG not null primary key,
	type_ VARCHAR(75) null,
	userId LONG,
	user2Id LONG,
	InstanceId LONG,
	offerId LONG,
	companyId LONG,
	createDate DATE null
);

create table msc_Category (
	categoryId LONG not null primary key,
	parentCategoryId LONG,
	name STRING null,
	position INTEGER,
	userId LONG,
	companyId LONG
);

create table msc_Deal (
	dealId LONG not null primary key,
	userId LONG,
	offerId LONG,
	companyId LONG,
	createDate DATE null
);

create table msc_Friendship (
	friendshipId LONG not null primary key,
	userId LONG,
	user2Id LONG,
	accepted BOOLEAN,
	rejected BOOLEAN,
	companyId LONG,
	createDate DATE null
);

create table msc_Instance (
	InstanceId LONG not null primary key,
	name VARCHAR(75) null,
	description STRING null,
	phoneNumber VARCHAR(75) null,
	faxNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	webPage VARCHAR(75) null,
	categoryLevel0 LONG,
	categoryLevel1 LONG,
	categoryLevel2 LONG,
	userId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null
);

create table msc_InstanceImage (
	InstanceImageId LONG not null primary key,
	InstanceId LONG,
	imageId LONG,
	imageURL VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	createDate DATE null
);

create table msc_Location (
	locationId LONG not null primary key,
	InstanceId LONG,
	address VARCHAR(75) null,
	lat DOUBLE,
	lng DOUBLE,
	phoneNumber VARCHAR(75) null,
	faxNumber VARCHAR(75) null,
	imageId LONG,
	imageURL VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	createDate DATE null
);

create table msc_Offer (
	offerId LONG not null primary key,
	InstanceId LONG,
	offerText STRING null,
	beginDate DATE null,
	endDate DATE null,
	price DOUBLE,
	transactions INTEGER,
	imageId LONG,
	imageURL VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	createDate DATE null,
	modifyDate DATE null
);