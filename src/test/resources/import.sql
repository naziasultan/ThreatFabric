insert into public.devices (DEVICE_UID, DEVICE_TYPE, DEVICE_MODEL, OS_VERSION) values ( '6319k9ed-3ca6-4169-897e-9812b108f1d3', 'WEB', 'windows', '10.045');
insert into public.devices (DEVICE_UID, DEVICE_TYPE, DEVICE_MODEL, OS_VERSION) values ( '8cf6l388-a121-4145-a058-4aee379d1d06', 'ANDROID', 'samsung note 9', '10');
insert into public.devices (DEVICE_UID, DEVICE_TYPE, DEVICE_MODEL, OS_VERSION) values ( '9cf6h388-a121-4145-0000-4aeo309d1d06', 'ANDROID', 'samsung note 20 ultra', '11');
insert into public.DETECTIONS (DEVICE_ID, time, NAME_OF_APP, TYPE_OF_APP,DETECTION_UID, type) values ( 2, '2021-06-10 12:00:00', 'test', 'test', '11f6b788-a121-4145-a058-4afl349d1d11', 'NEW');
insert into public.DETECTIONS (DEVICE_ID, time, NAME_OF_APP, TYPE_OF_APP,DETECTION_UID, type) values ( 3, '2021-06-11 01:10:00', 'test', 'test', '22f6b378-0000-4145-a058-4aeo349d1d11', 'NEW');
insert into public.DETECTIONS (DEVICE_ID, time, DETECTION_UID, type) values ( 3, '2021-06-11 02:11:00', '22j6b478-0000-4145-a058-4aee379d1k11', 'RESOLVED');
insert into public.DETECTIONS (DEVICE_ID, time, type) values ( 3, '2021-06-11 03:00:00', 'NO');