package com.dylankilbride.grouppay.Controllers;

import com.dylankilbride.grouppay.Models.*;
import com.dylankilbride.grouppay.ReturnObjects.ImageUploadResponse;
import com.dylankilbride.grouppay.Services.GroupAccountService;
import com.dylankilbride.grouppay.Services.S3ImageManagerService;
import com.dylankilbride.grouppay.Services.TransactionService;
import com.dylankilbride.grouppay.Services.VirtualCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/groupAccounts")
public class GroupAccountController {

	@Autowired
	GroupAccountService groupAccountService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	S3ImageManagerService s3ImageManagerService;
	@Autowired
	VirtualCardService virtualCardService;

	@RequestMapping(value = "/createBasicAccount",
					method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroupAccount createBasicGroupAccount(@RequestBody GroupAccount groupAccount) throws Exception{
		return groupAccountService.createBasicGroupAccount(groupAccount);
	}

	@RequestMapping(value = "/addParticipants/{groupAccountId}",
					method = RequestMethod.PUT,
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroupAccount addParticipantsToAccount(@PathVariable(name = "groupAccountId") long groupAccountId,
	                                             @RequestBody List<User> contacts) {
		return groupAccountService.addParticipantsToGroupAccount(groupAccountId, contacts);
	}

	@RequestMapping(value = "/getDetailedGroupInfo/{groupAccountId}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public GroupAccount getDetailedGroupInfo(@PathVariable(name = "groupAccountId") long groupAccountId) {
		return groupAccountService.getDetailedGroupAccountInfo(groupAccountId);
	}

	@RequestMapping(value = "/getAllUserAssociatedAccounts/{userId}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<GroupAccount> getAllUserAssociatedAccounts(@PathVariable(name = "userId") long userId) {
		return groupAccountService.getUserAssociatedAccounts(userId);
	}

	@RequestMapping(value = "/getAllContactsWithGrouppayAccounts",
						method = RequestMethod.POST,
						produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllContactsWithGrouppayAccounts(@RequestBody List<String> usersContactsPhoneNumbers) {
		return groupAccountService.getAllContactsWithGrouppayAccounts(usersContactsPhoneNumbers);
	}

	@RequestMapping(value = "/getGroupTransactions/{groupAccountId}",
						method = RequestMethod.GET,
						produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Transaction> getTransactionsForGroupAccount(@PathVariable(name = "groupAccountId") long groupAccountId) {
		return transactionService.getTransactionsForGroupAccount(groupAccountId);
	}

	@RequestMapping(value = "/uploadGroupProfileImage/{groupAccountId}",
					method = RequestMethod.POST,
					consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ImageUploadResponse uploadGroupProfileImage(@PathVariable("groupAccountId") String groupAccountId,
	                                                   @RequestPart MultipartFile file,
	                                                   @RequestPart("name") String body) {
		return groupAccountService.saveGroupProfilePhoto(groupAccountId,
						s3ImageManagerService.uploadFile(file).getFileUrl());
	}

	@RequestMapping(value = "/getAllUsersInGroup/{groupAccountId}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getGroupParticipants(@PathVariable("groupAccountId") String groupAccountId) {
		return groupAccountService.getGroupParticipants(groupAccountId);
	}

	@RequestMapping(value = "/deleteUserFromGroup/{groupAccountId}/{userId}",
					method = RequestMethod.DELETE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DeletionSuccess deleteParticipantFromGroup(@PathVariable("groupAccountId") String groupAccountId,
	                                                  @PathVariable("userId") String userId) {
		return groupAccountService.deleteGroupParticipant(groupAccountId, userId);
	}

	@RequestMapping(value = "/getVirtualCardDetails/{groupAccountId}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public VirtualCard getVCDetails(@PathVariable("groupAccountId") String groupAccountId) throws ParseException {
		return virtualCardService.getVirtualCardDetails(groupAccountId);
	}
}