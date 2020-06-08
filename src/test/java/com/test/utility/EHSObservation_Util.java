package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class EHSObservation_Util {

	static Xls_Reader reader;
	
	
	
	public static ArrayList<Object[]> GetDataFromExcel()
	{
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:/Users/GAURAV/workspace/GMR_Automation/src/main/java/com/textdata/GMR_Automation.xlsx");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum <= reader.getRowCount("EHSObservation"); rowNum++)
		{
			String UserName = reader.getCellData("EHSObservation", "UserName", rowNum);
			String Password = reader.getCellData("EHSObservation", "Password", rowNum);
			String Location = reader.getCellData("EHSObservation", "Location", rowNum);
			String ExactLocation = reader.getCellData("EHSObservation", "ExactLocation", rowNum);
			String ResponsibleFunction = reader.getCellData("EHSObservation", "ResponsibleFunction", rowNum);
			String Agency = reader.getCellData("EHSObservation", "Agency", rowNum);
			String ObservationCategory = reader.getCellData("EHSObservation", "ObservationCategory", rowNum);
			String NoOfPersons = reader.getCellData("EHSObservation", "NoOfPersons", rowNum);
			String ObservationSeverity = reader.getCellData("EHSObservation", "ObservationSeverity", rowNum);
			String ObservationType = reader.getCellData("EHSObservation", "ObservationType", rowNum);
			String ObservationDetail = reader.getCellData("EHSObservation", "ObservationDetail", rowNum);
			String Attachments1 = reader.getCellData("EHSObservation", "Attachments1", rowNum);
			String Attachments2 = reader.getCellData("EHSObservation", "Attachments2", rowNum);
			String Attachments3 = reader.getCellData("EHSObservation", "Attachments3", rowNum);
			String Attachments4 = reader.getCellData("EHSObservation", "Attachments4", rowNum);
			String ActiontobeTaken = reader.getCellData("EHSObservation", "ActiontobeTaken", rowNum);
			String Responsibility = reader.getCellData("EHSObservation", "Responsibility", rowNum);
			String Priority = reader.getCellData("EHSObservation", "Priority", rowNum);
			String SectionHeadUserName = reader.getCellData("EHSObservation", "SectionHeadUserName", rowNum);
			String SectionHeadPassword = reader.getCellData("EHSObservation", "SectionHeadPassword", rowNum);
			String Clickonthat = reader.getCellData("EHSObservation", "Clickonthat", rowNum);
			String AuthorizationactionSectionHead = reader.getCellData("EHSObservation", "AuthorizationactionSectionHead", rowNum);
			String CommentSectionHead = reader.getCellData("EHSObservation", "CommentSectionHead", rowNum);
			String CAPAPersonUserName = reader.getCellData("EHSObservation", "CAPAPersonUserName", rowNum);
			String CAPAPersonPassword = reader.getCellData("EHSObservation", "CAPAPersonPassword", rowNum);
			String ClickonAction = reader.getCellData("EHSObservation", "ClickonAction", rowNum);
			String CAPAPersonAuthorizationAction = reader.getCellData("EHSObservation", "CAPAPersonAuthorizationAction", rowNum);
			String capapersonComment = reader.getCellData("EHSObservation", "capapersonComment", rowNum);
			String CAPAReviewDHUsername = reader.getCellData("EHSObservation", "CAPAReviewDHUsername", rowNum);
			String CAPAReviewDHPassword = reader.getCellData("EHSObservation", "CAPAReviewDHPassword", rowNum);
			String CAPAReviewDHAuthorizationaction = reader.getCellData("EHSObservation", "CAPAReviewDHAuthorizationaction", rowNum);
			String CAPAReviewDHComment = reader.getCellData("EHSObservation", "CAPAReviewDHComment", rowNum);
			
			
			Object ob[]= { UserName,Password,Location,ExactLocation,ResponsibleFunction,Agency,ObservationCategory,NoOfPersons,ObservationSeverity,ObservationType,
					ObservationDetail,Attachments1,Attachments2,Attachments3,Attachments4,ActiontobeTaken,Responsibility,Priority,SectionHeadUserName,SectionHeadPassword,
					Clickonthat,AuthorizationactionSectionHead,CommentSectionHead,CAPAPersonUserName,CAPAPersonPassword,ClickonAction,CAPAPersonAuthorizationAction,
					capapersonComment,CAPAReviewDHUsername,CAPAReviewDHPassword,CAPAReviewDHAuthorizationaction,CAPAReviewDHComment

			};
			myData.add(ob);
		
			}

			return myData;
		
			}
	
		}
