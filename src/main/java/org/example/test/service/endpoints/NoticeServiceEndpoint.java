package org.example.test.service.endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.example.kickappnotice.service.NotificationRequestType;
import org.example.kickappnotice.service.NotificationStatus;
import org.example.test.service.NoticeService;


/**
 * The Class for notice
 */
@Endpoint
public class NoticeServiceEndpoint {
	//from xsd targetnameSpace http://www.example.org/KickappNotice/service
	private static final String TARGET_NAMESPACE = "http://www.example.org/KickappNotice/service";

	//@Autowired
	//private NoticeService noticeService_i;

	/**
	 * Gets the status for notificationInfo.
	 *
	 * @param notificationInfo
	 * @return the status
	 * PayloadRoot--process service requests with the XML root element matching that defined by the localPart attribute
	 */
	@PayloadRoot(localPart = "NoticeRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload NotificationStatus sendNoticeService(@RequestPayload NotificationRequestType request)
	{
		NotificationStatus st = new NotificationStatus();
		String s = "ok";//noticeService_i.sendNotice(request.getNotificationinfo());
		st.setReturnStatus(s);
		return st;
	}

	public void setNoticeService(NoticeService noticeService_i) {
		//this.noticeService_i = noticeService_i;
	}	

}
