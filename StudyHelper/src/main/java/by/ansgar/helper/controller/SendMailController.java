package by.ansgar.helper.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.ansgar.helper.util.SendMail;

@Controller
public class SendMailController {

	@RequestMapping(value = "/mail_form")
	public ModelAndView doSendMaiPage() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("send_mail");
		return mav;
	}

	@RequestMapping(value = "/send_mail", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView sendMail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String user = request.getParameter("mail");
		String password = request.getParameter("password");
		String text = request.getParameter("text");
		String[] studentsEmail = new String [GroupController.emails.size()];
			studentsEmail =	GroupController.emails.toArray(studentsEmail);

		// TODO
		if (SendMail.senMail(user, password, text, studentsEmail)) {
			System.out.println("Successfully");
		} else {
			System.out.println("Error");
		}

		mav.setViewName("forward:/main");
		return mav;
	}

}
