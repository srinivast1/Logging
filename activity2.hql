create table activity2(str String);

load data local inpath '/home/srini/activity2.json' overwrite  into table activity2;

select get_json_object(str,'$.userName') as UserName, get_json_object(str,'$.websiteName') as websiteName from activity2;

CREATE EXTERNAL TABLE activity2
(
activity2 ARRAY<STRING>
)
ROW FORMAT SERDE 'org.jsonserde.JsonSerDe'
LOCATION '/tmp/srini/activity2.json';