package org.example.test.service;

import org.example.kickappnotice.NoticeInfoType;

public class NoticeServiceImpl implements NoticeService {

	public String sendNotice(NoticeInfoType info) {
		// TODO Auto-generated method stub
		if (info.getCcn() != null){
			return "ok";
		}
		return "go";
	}

}
