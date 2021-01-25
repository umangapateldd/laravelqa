package com.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.testng.TestNG;

public class Frame {

	private JFrame frame;
	public static boolean userAddEditDelete = false;
	public static boolean PagesAddEditSaveButton = false;
	public static boolean ourteamAddEditSaveDeleteButton = false;
	public static boolean eventsAddEditDelete = false;
	public static boolean fAQsAddEditSaveButton = false;
	public static boolean blogAddEditSaveDeleteButton = false;
	public static boolean testimonialAddEditSaveDeleteButton = false;
	public static boolean CategoriesAddEditSaveDeleteButton = false;
	public static boolean IPTracker = false;
	public static boolean contactInquiry = false;
	public static boolean galleryAddEditDelete = false;
	public static boolean homeSliderAddEditSaveDelete = false;
	public static boolean multiplecategoriesAED = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btn_execution = new JButton("Execute Script");
		btn_execution.setBounds(223, 435, 133, 23);
		frame.getContentPane().add(btn_execution);

		JCheckBox chkUserAddEditDelete = new JCheckBox(" AED");
		chkUserAddEditDelete.setBounds(6, 44, 82, 23);
		frame.getContentPane().add(chkUserAddEditDelete);

		JCheckBox chkPageAddEditDelete = new JCheckBox("AED");
		chkPageAddEditDelete.setBounds(117, 44, 73, 23);
		frame.getContentPane().add(chkPageAddEditDelete);

		JCheckBox chkourteamAddEditDelete = new JCheckBox("AED");
		chkourteamAddEditDelete.setBounds(6, 255, 97, 23);
		frame.getContentPane().add(chkourteamAddEditDelete);

		JCheckBox chkcategoriesAddEditDelete = new JCheckBox("AED");
		chkcategoriesAddEditDelete.setBounds(242, 48, 97, 29);
		frame.getContentPane().add(chkcategoriesAddEditDelete);

		JCheckBox chktestimonialAddEditDelete = new JCheckBox("AED");
		chktestimonialAddEditDelete.setBounds(139, 262, 97, 23);
		frame.getContentPane().add(chktestimonialAddEditDelete);

		JCheckBox chkblogAddEditDelete = new JCheckBox("AED");
		chkblogAddEditDelete.setBounds(341, 51, 97, 23);
		frame.getContentPane().add(chkblogAddEditDelete);

		JCheckBox chkfaqAddEditDelete = new JCheckBox("AEDScontinuous");
		chkfaqAddEditDelete.setBounds(440, 77, 97, 23);
		frame.getContentPane().add(chkfaqAddEditDelete);

		JCheckBox chkeventAddEditDelete = new JCheckBox("AED");
		chkeventAddEditDelete.setBounds(258, 262, 97, 23);
		frame.getContentPane().add(chkeventAddEditDelete);

		JCheckBox chkIPTracker = new JCheckBox("IPTracker");
		chkIPTracker.setBounds(358, 262, 97, 23);
		frame.getContentPane().add(chkIPTracker);

		JCheckBox chkUserAEDSContinuous = new JCheckBox("AEDSContinuous");
		chkUserAEDSContinuous.setBounds(6, 70, 97, 23);
		frame.getContentPane().add(chkUserAEDSContinuous);

		JCheckBox chkmultipleuserAD = new JCheckBox("MultipleAD");
		chkmultipleuserAD.setBounds(6, 96, 97, 23);
		frame.getContentPane().add(chkmultipleuserAD);

		JCheckBox chkUserPagination = new JCheckBox("Pagination");
		chkUserPagination.setBounds(6, 148, 97, 23);
		frame.getContentPane().add(chkUserPagination);

		JCheckBox chkUsersorting = new JCheckBox("Sorting");
		chkUsersorting.setBounds(6, 175, 97, 23);
		frame.getContentPane().add(chkUsersorting);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Status");
		chckbxNewCheckBox_4.setBounds(6, 122, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_4);

		JCheckBox chkPageAEDSContinuous = new JCheckBox("AEDSContinuous");
		chkPageAEDSContinuous.setBounds(117, 70, 97, 23);
		frame.getContentPane().add(chkPageAEDSContinuous);

		JCheckBox chkmultiplepageAdd = new JCheckBox("MultipleAD");
		chkmultiplepageAdd.setBounds(117, 122, 97, 23);
		frame.getContentPane().add(chkmultiplepageAdd);

		JCheckBox chkPagessorting = new JCheckBox("Sorting");
		chkPagessorting.setBounds(117, 96, 97, 23);
		frame.getContentPane().add(chkPagessorting);

		JCheckBox chkOurTeamAEDSContinuous = new JCheckBox("AEDSContinuous");
		chkOurTeamAEDSContinuous.setBounds(6, 281, 97, 23);
		frame.getContentPane().add(chkOurTeamAEDSContinuous);

		JCheckBox chkourteamPagination = new JCheckBox("Pagination");
		chkourteamPagination.setBounds(6, 333, 97, 23);
		frame.getContentPane().add(chkourteamPagination);

		JCheckBox chkourteamsorting = new JCheckBox("Sorting");
		chkourteamsorting.setBounds(6, 359, 97, 23);
		frame.getContentPane().add(chkourteamsorting);

		JCheckBox chkCategoriesAESContinue = new JCheckBox("AESContinue");
		chkCategoriesAESContinue.setBounds(242, 70, 97, 23);
		frame.getContentPane().add(chkCategoriesAESContinue);

		JCheckBox chkmultiplecategoriesAED = new JCheckBox("MultipleAD");
		chkmultiplecategoriesAED.setBounds(242, 175, 97, 23);
		frame.getContentPane().add(chkmultiplecategoriesAED);

		JCheckBox chkcategoriesPagination = new JCheckBox("Pagination");
		chkcategoriesPagination.setBounds(242, 122, 97, 23);
		frame.getContentPane().add(chkcategoriesPagination);

		JCheckBox chkcategoriessorting = new JCheckBox("Sorting");
		chkcategoriessorting.setBounds(242, 148, 97, 23);
		frame.getContentPane().add(chkcategoriessorting);

		JCheckBox chkCategoriesstatus = new JCheckBox("Status");
		chkCategoriesstatus.setBounds(242, 96, 97, 23);
		frame.getContentPane().add(chkCategoriesstatus);

		JCheckBox chkTestimonialAEDSContinue = new JCheckBox("AEDSContinue");
		chkTestimonialAEDSContinue.setBounds(139, 287, 97, 23);
		frame.getContentPane().add(chkTestimonialAEDSContinue);

		JCheckBox chkTestimonialSettings = new JCheckBox("Settings");
		chkTestimonialSettings.setBounds(139, 379, 97, 23);
		frame.getContentPane().add(chkTestimonialSettings);

		JCheckBox chkmultipletestimonialAD = new JCheckBox("MultipleAD");
		chkmultipletestimonialAD.setBounds(139, 333, 97, 23);
		frame.getContentPane().add(chkmultipletestimonialAD);

		JCheckBox chkTestimonialPagination = new JCheckBox("Pagination");
		chkTestimonialPagination.setBounds(139, 405, 97, 23);
		frame.getContentPane().add(chkTestimonialPagination);

		JCheckBox chkTestimonialsorting = new JCheckBox("Sorting");
		chkTestimonialsorting.setBounds(139, 359, 97, 23);
		frame.getContentPane().add(chkTestimonialsorting);

		JCheckBox chkBlogStatus = new JCheckBox("Status");
		chkBlogStatus.setBounds(341, 122, 97, 23);
		frame.getContentPane().add(chkBlogStatus);

		JCheckBox chkBlogAESContinue = new JCheckBox("AESContinue");
		chkBlogAESContinue.setBounds(341, 77, 97, 23);
		frame.getContentPane().add(chkBlogAESContinue);

		JCheckBox chkBlogSettings = new JCheckBox("Settings");
		chkBlogSettings.setBounds(341, 148, 97, 23);
		frame.getContentPane().add(chkBlogSettings);

		JCheckBox chkmultipleblogAD = new JCheckBox("MultipleAD");
		chkmultipleblogAD.setBounds(341, 190, 97, 42);
		frame.getContentPane().add(chkmultipleblogAD);

		JCheckBox chkBlogPagination = new JCheckBox("Pagination");
		chkBlogPagination.setBounds(341, 103, 97, 23);
		frame.getContentPane().add(chkBlogPagination);

		JCheckBox chkBlogsorting = new JCheckBox("Sorting");
		chkBlogsorting.setBounds(341, 175, 97, 23);
		frame.getContentPane().add(chkBlogsorting);

		JCheckBox chkFAQStatus = new JCheckBox("Status");
		chkFAQStatus.setBounds(440, 103, 97, 23);
		frame.getContentPane().add(chkFAQStatus);

		JCheckBox chkmultipleteFAQAD = new JCheckBox("MultipleAD");
		chkmultipleteFAQAD.setBounds(440, 175, 97, 23);
		frame.getContentPane().add(chkmultipleteFAQAD);

		JCheckBox chkFAQPagination = new JCheckBox("Pagination");
		chkFAQPagination.setBounds(440, 148, 97, 23);
		frame.getContentPane().add(chkFAQPagination);

		JCheckBox chkFAQsorting = new JCheckBox("Sorting");
		chkFAQsorting.setBounds(440, 122, 97, 23);
		frame.getContentPane().add(chkFAQsorting);

		JCheckBox chkEventsStatus = new JCheckBox("Status");
		chkEventsStatus.setBounds(259, 307, 97, 23);
		frame.getContentPane().add(chkEventsStatus);

		JCheckBox chkEventsAEDSContinous = new JCheckBox("AEDSContinous");
		chkEventsAEDSContinous.setBounds(259, 281, 97, 23);
		frame.getContentPane().add(chkEventsAEDSContinous);

		JCheckBox chkEventssorting = new JCheckBox("Sorting");
		chkEventssorting.setBounds(258, 333, 97, 23);
		frame.getContentPane().add(chkEventssorting);

		JCheckBox chkEventsPagination = new JCheckBox("Pagination");
		chkEventsPagination.setBounds(258, 359, 97, 23);
		frame.getContentPane().add(chkEventsPagination);

		JCheckBox chkconatctinquiries = new JCheckBox("Conatctinquiries");
		chkconatctinquiries.setBounds(457, 255, 97, 23);
		frame.getContentPane().add(chkconatctinquiries);

		JCheckBox chkFAQAED = new JCheckBox("AED");
		chkFAQAED.setBounds(440, 44, 97, 23);
		frame.getContentPane().add(chkFAQAED);

		JCheckBox chkOurteamstatus = new JCheckBox("Status");
		chkOurteamstatus.setBounds(6, 307, 97, 23);
		frame.getContentPane().add(chkOurteamstatus);

		JCheckBox chkOurteamMultipleAD = new JCheckBox("MultipleAD");
		chkOurteamMultipleAD.setBounds(6, 390, 97, 23);
		frame.getContentPane().add(chkOurteamMultipleAD);

		JTextPane txtpnUsers = new JTextPane();
		txtpnUsers.setText("Users");
		txtpnUsers.setBounds(21, 22, 44, 20);
		frame.getContentPane().add(txtpnUsers);

		JTextArea txtrPages = new JTextArea();
		txtrPages.setText("Pages");
		txtrPages.setBounds(128, 22, 48, 23);
		frame.getContentPane().add(txtrPages);

		JTextArea txtrCategories = new JTextArea();
		txtrCategories.setText("Categories");
		txtrCategories.setBounds(242, 24, 89, 22);
		frame.getContentPane().add(txtrCategories);

		JTextArea txtrBlog = new JTextArea();
		txtrBlog.setText("Blog");
		txtrBlog.setBounds(360, 24, 43, 24);
		frame.getContentPane().add(txtrBlog);

		JTextArea txtrFaq = new JTextArea();
		txtrFaq.setText("FAQs");
		txtrFaq.setBounds(440, 22, 42, 22);
		frame.getContentPane().add(txtrFaq);

		JTextArea txtrOurTeam = new JTextArea();
		txtrOurTeam.setText("Our Team");
		txtrOurTeam.setBounds(17, 233, 71, 22);
		frame.getContentPane().add(txtrOurTeam);

		JTextArea txtrTestimonials = new JTextArea();
		txtrTestimonials.setText("Testimonials");
		txtrTestimonials.setBounds(139, 233, 107, 22);
		frame.getContentPane().add(txtrTestimonials);

		JTextArea txtrEvents = new JTextArea();
		txtrEvents.setText("Events");
		txtrEvents.setBounds(280, 233, 59, 22);
		frame.getContentPane().add(txtrEvents);

		JTextArea txtrIpTrakcer = new JTextArea();
		txtrIpTrakcer.setText("IP Trakcer");
		txtrIpTrakcer.setBounds(366, 233, 89, 20);
		frame.getContentPane().add(txtrIpTrakcer);

		JTextArea txtrContact = new JTextArea();
		txtrContact.setText("Contact");
		txtrContact.setBounds(465, 233, 59, 22);
		frame.getContentPane().add(txtrContact);

		JCheckBox chkPagesstatus = new JCheckBox("Status");
		chkPagesstatus.setBounds(117, 148, 97, 23);
		frame.getContentPane().add(chkPagesstatus);

		JCheckBox chkPagination = new JCheckBox("Pagination");
		chkPagination.setBounds(117, 175, 97, 23);
		frame.getContentPane().add(chkPagination);

		JCheckBox chkTestimonialstatus = new JCheckBox("Status");
		chkTestimonialstatus.setBounds(139, 307, 97, 23);
		frame.getContentPane().add(chkTestimonialstatus);

		JCheckBox chckbxNewCheckBox = new JCheckBox("MultipleAD");
		chckbxNewCheckBox.setBounds(259, 390, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);

		JTextArea txtrGallery = new JTextArea();
		txtrGallery.setText("Gallery");
		txtrGallery.setBounds(549, 233, 59, 22);
		frame.getContentPane().add(txtrGallery);

		JCheckBox chkgallery = new JCheckBox("AED");
		chkgallery.setBounds(549, 255, 97, 23);
		frame.getContentPane().add(chkgallery);

		JTextArea txtrHomeslider = new JTextArea();
		txtrHomeslider.setText("HomeSlider");
		txtrHomeslider.setBounds(511, 22, 97, 22);
		frame.getContentPane().add(txtrHomeslider);

		JCheckBox chkHomeslider = new JCheckBox("AED");
		chkHomeslider.setBounds(539, 44, 107, 23);
		frame.getContentPane().add(chkHomeslider);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Settings");
		chckbxNewCheckBox_3.setBounds(536, 77, 82, 23);
		frame.getContentPane().add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Settings");
		chckbxNewCheckBox_5.setBounds(6, 416, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_5);

		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Settings");
		chckbxNewCheckBox_6.setBounds(457, 287, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox_6);

		btn_execution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkUserAddEditDelete.isSelected()) {
					userAddEditDelete = true;
				}
				if (chkPageAddEditDelete.isSelected()) {
					PagesAddEditSaveButton = true;
				}

				if (chkourteamAddEditDelete.isSelected()) {
					ourteamAddEditSaveDeleteButton = true;
				}
				if (chkcategoriesAddEditDelete.isSelected()) {
					CategoriesAddEditSaveDeleteButton = true;
				}
				if (chkblogAddEditDelete.isSelected()) {
					blogAddEditSaveDeleteButton = true;
				}

				if (chktestimonialAddEditDelete.isSelected()) {
					testimonialAddEditSaveDeleteButton = true;
				}
				if (chkeventAddEditDelete.isSelected()) {
					eventsAddEditDelete = true;
				}
				if (chkIPTracker.isSelected()) {
					IPTracker = true;
				}
				if (chkconatctinquiries.isSelected()) {
					contactInquiry = true;
				}
				if (chkgallery.isSelected()) {
					galleryAddEditDelete = true;
				}
				if (chkHomeslider.isSelected()) {
					homeSliderAddEditSaveDelete = true;
				}

				if (chkmultiplecategoriesAED.isSelected()) {
					multiplecategoriesAED = true;
				}

				TestNG testSuite = new TestNG();
				testSuite.setTestClasses(new Class[] { TestMain.class });
				testSuite.run();
			}
		});
	}
}
