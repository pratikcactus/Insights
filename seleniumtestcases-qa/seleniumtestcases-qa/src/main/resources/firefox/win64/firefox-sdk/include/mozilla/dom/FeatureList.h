#ifndef mozilla_dom_FeatureList_h
#define mozilla_dom_FeatureList_h

#include "nsString.h"

namespace mozilla {
namespace dom {
bool IsFeatureDetectible(const nsAString& aFeature) {
  static const char* const FeatureList[] = {
    "AVInputPort",
    "BeforeAfterKeyboardEvent",
    "BeforeAfterKeyboardEvent.embeddedCancelled",
    "BeforeAfterKeyboardEvent.isTrusted",
    "BrowserElementAudioChannel",
    "BrowserElementAudioChannel.getMuted",
    "BrowserElementAudioChannel.getVolume",
    "BrowserElementAudioChannel.isActive",
    "BrowserElementAudioChannel.name",
    "BrowserElementAudioChannel.notifyChannel",
    "BrowserElementAudioChannel.onactivestatechanged",
    "BrowserElementAudioChannel.setMuted",
    "BrowserElementAudioChannel.setVolume",
    "BrowserElementProxy.addNextPaintListener",
    "BrowserElementProxy.allowedAudioChannels",
    "BrowserElementProxy.clearMatch",
    "BrowserElementProxy.download",
    "BrowserElementProxy.executeScript",
    "BrowserElementProxy.findAll",
    "BrowserElementProxy.findNext",
    "BrowserElementProxy.getActive",
    "BrowserElementProxy.getCanGoBack",
    "BrowserElementProxy.getCanGoForward",
    "BrowserElementProxy.getContentDimensions",
    "BrowserElementProxy.getMuted",
    "BrowserElementProxy.getScreenshot",
    "BrowserElementProxy.getStructuredData",
    "BrowserElementProxy.getVisible",
    "BrowserElementProxy.getVolume",
    "BrowserElementProxy.getWebManifest",
    "BrowserElementProxy.goBack",
    "BrowserElementProxy.goForward",
    "BrowserElementProxy.mute",
    "BrowserElementProxy.purgeHistory",
    "BrowserElementProxy.reload",
    "BrowserElementProxy.removeNextPaintListener",
    "BrowserElementProxy.sendMouseEvent",
    "BrowserElementProxy.sendTouchEvent",
    "BrowserElementProxy.setActive",
    "BrowserElementProxy.setInputMethodActive",
    "BrowserElementProxy.setNFCFocus",
    "BrowserElementProxy.setVisible",
    "BrowserElementProxy.setVolume",
    "BrowserElementProxy.stop",
    "BrowserElementProxy.unmute",
    "BrowserElementProxy.zoom",
    "DOMDownload",
    "DOMDownload.contentType",
    "DOMDownload.currentBytes",
    "DOMDownload.error",
    "DOMDownload.id",
    "DOMDownload.onstatechange",
    "DOMDownload.path",
    "DOMDownload.pause",
    "DOMDownload.resume",
    "DOMDownload.sourceAppManifestURL",
    "DOMDownload.startTime",
    "DOMDownload.state",
    "DOMDownload.storageName",
    "DOMDownload.storagePath",
    "DOMDownload.totalBytes",
    "DOMDownload.url",
    "DOMMobileMessageError",
    "DOMMobileMessageError.data",
    "DisplayPortInputPort",
    "DownloadEvent",
    "DownloadEvent.download",
    "DownloadEvent.isTrusted",
    "ExternalAppEvent",
    "ExternalAppEvent.data",
    "ExternalAppEvent.isTrusted",
    "HDMIInputPort",
    "HTMLExtAppElement",
    "HTMLExtAppElement.getCustomProperty",
    "HTMLExtAppElement.postMessage",
    "HTMLIFrameElement.addNextPaintListener",
    "HTMLIFrameElement.allowedAudioChannels",
    "HTMLIFrameElement.clearMatch",
    "HTMLIFrameElement.download",
    "HTMLIFrameElement.executeScript",
    "HTMLIFrameElement.findAll",
    "HTMLIFrameElement.findNext",
    "HTMLIFrameElement.getActive",
    "HTMLIFrameElement.getCanGoBack",
    "HTMLIFrameElement.getCanGoForward",
    "HTMLIFrameElement.getContentDimensions",
    "HTMLIFrameElement.getMuted",
    "HTMLIFrameElement.getScreenshot",
    "HTMLIFrameElement.getStructuredData",
    "HTMLIFrameElement.getVisible",
    "HTMLIFrameElement.getVolume",
    "HTMLIFrameElement.getWebManifest",
    "HTMLIFrameElement.goBack",
    "HTMLIFrameElement.goForward",
    "HTMLIFrameElement.mute",
    "HTMLIFrameElement.purgeHistory",
    "HTMLIFrameElement.reload",
    "HTMLIFrameElement.removeNextPaintListener",
    "HTMLIFrameElement.sendMouseEvent",
    "HTMLIFrameElement.sendTouchEvent",
    "HTMLIFrameElement.setActive",
    "HTMLIFrameElement.setInputMethodActive",
    "HTMLIFrameElement.setNFCFocus",
    "HTMLIFrameElement.setVisible",
    "HTMLIFrameElement.setVolume",
    "HTMLIFrameElement.stop",
    "HTMLIFrameElement.unmute",
    "HTMLIFrameElement.zoom",
    "IccCardLockError",
    "IccCardLockError.retryCount",
    "IccChangeEvent",
    "IccChangeEvent.iccId",
    "IccChangeEvent.isTrusted",
    "InputPort",
    "InputPort.connected",
    "InputPort.id",
    "InputPort.onconnect",
    "InputPort.ondisconnect",
    "InputPort.stream",
    "InputPortManager",
    "InputPortManager.getInputPorts",
    "MMICall",
    "MMICall.result",
    "MmsMessage",
    "MmsMessage.attachments",
    "MmsMessage.delivery",
    "MmsMessage.deliveryInfo",
    "MmsMessage.expiryDate",
    "MmsMessage.iccId",
    "MmsMessage.id",
    "MmsMessage.read",
    "MmsMessage.readReportRequested",
    "MmsMessage.receivers",
    "MmsMessage.sender",
    "MmsMessage.sentTimestamp",
    "MmsMessage.smil",
    "MmsMessage.subject",
    "MmsMessage.threadId",
    "MmsMessage.timestamp",
    "MmsMessage.type",
    "MobileMessageThread",
    "MobileMessageThread.body",
    "MobileMessageThread.id",
    "MobileMessageThread.lastMessageSubject",
    "MobileMessageThread.lastMessageType",
    "MobileMessageThread.participants",
    "MobileMessageThread.timestamp",
    "MobileMessageThread.unreadCount",
    "MozCdmaIccInfo",
    "MozCdmaIccInfo.mdn",
    "MozCdmaIccInfo.prlVersion",
    "MozCellBroadcast",
    "MozCellBroadcast.onreceived",
    "MozCellBroadcastEtwsInfo",
    "MozCellBroadcastEtwsInfo.emergencyUserAlert",
    "MozCellBroadcastEtwsInfo.popup",
    "MozCellBroadcastEtwsInfo.warningType",
    "MozCellBroadcastEvent",
    "MozCellBroadcastEvent.isTrusted",
    "MozCellBroadcastEvent.message",
    "MozCellBroadcastMessage",
    "MozCellBroadcastMessage.body",
    "MozCellBroadcastMessage.cdmaServiceCategory",
    "MozCellBroadcastMessage.etws",
    "MozCellBroadcastMessage.gsmGeographicalScope",
    "MozCellBroadcastMessage.language",
    "MozCellBroadcastMessage.messageClass",
    "MozCellBroadcastMessage.messageCode",
    "MozCellBroadcastMessage.messageId",
    "MozCellBroadcastMessage.serviceId",
    "MozCellBroadcastMessage.timestamp",
    "MozGsmIccInfo",
    "MozGsmIccInfo.msisdn",
    "MozIcc",
    "MozIcc.cardState",
    "MozIcc.getCardLock",
    "MozIcc.getCardLockRetryCount",
    "MozIcc.getServiceState",
    "MozIcc.iccInfo",
    "MozIcc.matchMvno",
    "MozIcc.oncardstatechange",
    "MozIcc.oniccinfochange",
    "MozIcc.onstkcommand",
    "MozIcc.onstksessionend",
    "MozIcc.readContacts",
    "MozIcc.sendStkEventDownload",
    "MozIcc.sendStkMenuSelection",
    "MozIcc.sendStkResponse",
    "MozIcc.sendStkTimerExpiration",
    "MozIcc.setCardLock",
    "MozIcc.unlockCardLock",
    "MozIcc.updateContact",
    "MozIccInfo",
    "MozIccInfo.iccType",
    "MozIccInfo.iccid",
    "MozIccInfo.isDisplayNetworkNameRequired",
    "MozIccInfo.isDisplaySpnRequired",
    "MozIccInfo.mcc",
    "MozIccInfo.mnc",
    "MozIccInfo.spn",
    "MozIccManager",
    "MozIccManager.STK_ADDITIONAL_INFO_ME_PROBLEM_SCREEN_IS_BUSY",
    "MozIccManager.STK_BROWSER_MODE_LAUNCH_IF_NOT_ALREADY_LAUNCHED",
    "MozIccManager.STK_BROWSER_MODE_USING_EXISTING_BROWSER",
    "MozIccManager.STK_BROWSER_MODE_USING_NEW_BROWSER",
    "MozIccManager.STK_BROWSER_TERMINATION_CAUSE_ERROR",
    "MozIccManager.STK_BROWSER_TERMINATION_CAUSE_USER",
    "MozIccManager.STK_CMD_CLOSE_CHANNEL",
    "MozIccManager.STK_CMD_DISPLAY_TEXT",
    "MozIccManager.STK_CMD_GET_INKEY",
    "MozIccManager.STK_CMD_GET_INPUT",
    "MozIccManager.STK_CMD_LAUNCH_BROWSER",
    "MozIccManager.STK_CMD_OPEN_CHANNEL",
    "MozIccManager.STK_CMD_PLAY_TONE",
    "MozIccManager.STK_CMD_POLL_INTERVAL",
    "MozIccManager.STK_CMD_POLL_OFF",
    "MozIccManager.STK_CMD_PROVIDE_LOCAL_INFO",
    "MozIccManager.STK_CMD_RECEIVE_DATA",
    "MozIccManager.STK_CMD_REFRESH",
    "MozIccManager.STK_CMD_SELECT_ITEM",
    "MozIccManager.STK_CMD_SEND_DATA",
    "MozIccManager.STK_CMD_SEND_DTMF",
    "MozIccManager.STK_CMD_SEND_SMS",
    "MozIccManager.STK_CMD_SEND_SS",
    "MozIccManager.STK_CMD_SEND_USSD",
    "MozIccManager.STK_CMD_SET_UP_CALL",
    "MozIccManager.STK_CMD_SET_UP_EVENT_LIST",
    "MozIccManager.STK_CMD_SET_UP_IDLE_MODE_TEXT",
    "MozIccManager.STK_CMD_SET_UP_MENU",
    "MozIccManager.STK_CMD_TIMER_MANAGEMENT",
    "MozIccManager.STK_EVENT_TYPE_BROWSER_TERMINATION",
    "MozIccManager.STK_EVENT_TYPE_BROWSING_STATUS",
    "MozIccManager.STK_EVENT_TYPE_CALL_CONNECTED",
    "MozIccManager.STK_EVENT_TYPE_CALL_DISCONNECTED",
    "MozIccManager.STK_EVENT_TYPE_CARD_READER_STATUS",
    "MozIccManager.STK_EVENT_TYPE_CHANNEL_STATUS",
    "MozIccManager.STK_EVENT_TYPE_DATA_AVAILABLE",
    "MozIccManager.STK_EVENT_TYPE_DISPLAY_PARAMETER_CHANGED",
    "MozIccManager.STK_EVENT_TYPE_FRAMES_INFORMATION_CHANGED",
    "MozIccManager.STK_EVENT_TYPE_IDLE_SCREEN_AVAILABLE",
    "MozIccManager.STK_EVENT_TYPE_LANGUAGE_SELECTION",
    "MozIccManager.STK_EVENT_TYPE_LOCAL_CONNECTION",
    "MozIccManager.STK_EVENT_TYPE_LOCATION_STATUS",
    "MozIccManager.STK_EVENT_TYPE_MT_CALL",
    "MozIccManager.STK_EVENT_TYPE_NETWORK_SEARCH_MODE_CHANGED",
    "MozIccManager.STK_EVENT_TYPE_SINGLE_ACCESS_TECHNOLOGY_CHANGED",
    "MozIccManager.STK_EVENT_TYPE_USER_ACTIVITY",
    "MozIccManager.STK_LOCAL_INFO_DATE_TIME_ZONE",
    "MozIccManager.STK_LOCAL_INFO_IMEI",
    "MozIccManager.STK_LOCAL_INFO_LANGUAGE",
    "MozIccManager.STK_LOCAL_INFO_LOCATION_INFO",
    "MozIccManager.STK_MENU_TYPE_DATA_VALUES",
    "MozIccManager.STK_MENU_TYPE_NAVIGATION_OPTIONS",
    "MozIccManager.STK_MENU_TYPE_NOT_SPECIFIED",
    "MozIccManager.STK_NEXT_ACTION_END_PROACTIVE_SESSION",
    "MozIccManager.STK_NEXT_ACTION_NULL",
    "MozIccManager.STK_RESULT_ACTION_CONTRADICTION_TIMER_STATE",
    "MozIccManager.STK_RESULT_BACKWARD_MOVE_BY_USER",
    "MozIccManager.STK_RESULT_BEYOND_TERMINAL_CAPABILITY",
    "MozIccManager.STK_RESULT_BIP_ERROR",
    "MozIccManager.STK_RESULT_CMD_DATA_NOT_UNDERSTOOD",
    "MozIccManager.STK_RESULT_CMD_NUM_NOT_KNOWN",
    "MozIccManager.STK_RESULT_CMD_TYPE_NOT_UNDERSTOOD",
    "MozIccManager.STK_RESULT_HELP_INFO_REQUIRED",
    "MozIccManager.STK_RESULT_LAUNCH_BROWSER_ERROR",
    "MozIccManager.STK_RESULT_MULTI_CARDS_CMD_ERROR",
    "MozIccManager.STK_RESULT_NETWORK_CRNTLY_UNABLE_TO_PROCESS",
    "MozIccManager.STK_RESULT_NO_RESPONSE_FROM_USER",
    "MozIccManager.STK_RESULT_OK",
    "MozIccManager.STK_RESULT_PRFRMD_ICON_NOT_DISPLAYED",
    "MozIccManager.STK_RESULT_PRFRMD_LIMITED_SERVICE",
    "MozIccManager.STK_RESULT_PRFRMD_WITH_ADDITIONAL_EFS_READ",
    "MozIccManager.STK_RESULT_PRFRMD_WITH_MISSING_INFO",
    "MozIccManager.STK_RESULT_PRFRMD_WITH_PARTIAL_COMPREHENSION",
    "MozIccManager.STK_RESULT_REQUIRED_VALUES_MISSING",
    "MozIccManager.STK_RESULT_SMS_RP_ERROR",
    "MozIccManager.STK_RESULT_SS_RETURN_ERROR",
    "MozIccManager.STK_RESULT_TERMINAL_CRNTLY_UNABLE_TO_PROCESS",
    "MozIccManager.STK_RESULT_UICC_SESSION_TERM_BY_USER",
    "MozIccManager.STK_RESULT_USER_CLEAR_DOWN_CALL",
    "MozIccManager.STK_RESULT_USER_NOT_ACCEPT",
    "MozIccManager.STK_RESULT_USIM_CALL_CONTROL_PERMANENT",
    "MozIccManager.STK_RESULT_USSD_RETURN_ERROR",
    "MozIccManager.STK_RESULT_USSD_SS_SESSION_TERM_BY_USER",
    "MozIccManager.STK_SERVICE_STATE_LIMITED",
    "MozIccManager.STK_SERVICE_STATE_NORMAL",
    "MozIccManager.STK_SERVICE_STATE_UNAVAILABLE",
    "MozIccManager.STK_TIMER_DEACTIVATE",
    "MozIccManager.STK_TIMER_GET_CURRENT_VALUE",
    "MozIccManager.STK_TIMER_START",
    "MozIccManager.STK_TIME_UNIT_MINUTE",
    "MozIccManager.STK_TIME_UNIT_SECOND",
    "MozIccManager.STK_TIME_UNIT_TENTH_SECOND",
    "MozIccManager.STK_TONE_TYPE_CALLED_SUBSCRIBER_BUSY",
    "MozIccManager.STK_TONE_TYPE_CALL_WAITING_TONE",
    "MozIccManager.STK_TONE_TYPE_CONGESTION",
    "MozIccManager.STK_TONE_TYPE_DIAL_TONE",
    "MozIccManager.STK_TONE_TYPE_ERROR",
    "MozIccManager.STK_TONE_TYPE_GENERAL_BEEP",
    "MozIccManager.STK_TONE_TYPE_NEGATIVE_ACK_TONE",
    "MozIccManager.STK_TONE_TYPE_POSITIVE_ACK_TONE",
    "MozIccManager.STK_TONE_TYPE_RADIO_PATH_ACK",
    "MozIccManager.STK_TONE_TYPE_RADIO_PATH_NOT_AVAILABLE",
    "MozIccManager.STK_TONE_TYPE_RINGING_TONE",
    "MozIccManager.getIccById",
    "MozIccManager.iccIds",
    "MozIccManager.oniccdetected",
    "MozIccManager.oniccundetected",
    "MozInputContext",
    "MozInputContext.deleteSurroundingText",
    "MozInputContext.endComposition",
    "MozInputContext.getText",
    "MozInputContext.inputMode",
    "MozInputContext.inputType",
    "MozInputContext.keydown",
    "MozInputContext.keyup",
    "MozInputContext.lang",
    "MozInputContext.onselectionchange",
    "MozInputContext.onsurroundingtextchange",
    "MozInputContext.replaceSurroundingText",
    "MozInputContext.selectionEnd",
    "MozInputContext.selectionStart",
    "MozInputContext.sendKey",
    "MozInputContext.setComposition",
    "MozInputContext.setSelectionRange",
    "MozInputContext.text",
    "MozInputContext.textAfterCursor",
    "MozInputContext.textBeforeCursor",
    "MozInputContext.type",
    "MozInputContextFocusEventDetail",
    "MozInputContextFocusEventDetail.choices",
    "MozInputContextFocusEventDetail.inputType",
    "MozInputContextFocusEventDetail.max",
    "MozInputContextFocusEventDetail.min",
    "MozInputContextFocusEventDetail.type",
    "MozInputContextFocusEventDetail.value",
    "MozInputContextSelectionChangeEventDetail",
    "MozInputContextSelectionChangeEventDetail.ownAction",
    "MozInputContextSelectionChangeEventDetail.selectionEnd",
    "MozInputContextSelectionChangeEventDetail.selectionStart",
    "MozInputContextSurroundingTextChangeEventDetail",
    "MozInputContextSurroundingTextChangeEventDetail.ownAction",
    "MozInputContextSurroundingTextChangeEventDetail.text",
    "MozInputContextSurroundingTextChangeEventDetail.textAfterCursor",
    "MozInputContextSurroundingTextChangeEventDetail.textBeforeCursor",
    "MozInputMethod.addInput",
    "MozInputMethod.inputcontext",
    "MozInputMethod.oninputcontextchange",
    "MozInputMethod.removeFocus",
    "MozInputMethod.removeInput",
    "MozInputMethod.setSelectedOption",
    "MozInputMethod.setSelectedOptions",
    "MozInputMethod.setValue",
    "MozInputMethodManager",
    "MozInputMethodManager.hide",
    "MozInputMethodManager.next",
    "MozInputMethodManager.onaddinputrequest",
    "MozInputMethodManager.oninputcontextblur",
    "MozInputMethodManager.oninputcontextfocus",
    "MozInputMethodManager.onnextrequest",
    "MozInputMethodManager.onremoveinputrequest",
    "MozInputMethodManager.onshowallrequest",
    "MozInputMethodManager.setSupportsSwitchingTypes",
    "MozInputMethodManager.showAll",
    "MozInputMethodManager.supportsSwitching",
    "MozInputRegistryEventDetail",
    "MozInputRegistryEventDetail.inputId",
    "MozInputRegistryEventDetail.inputManifest",
    "MozInputRegistryEventDetail.manifestURL",
    "MozInputRegistryEventDetail.waitUntil",
    "MozMessageDeletedEvent",
    "MozMessageDeletedEvent.deletedMessageIds",
    "MozMessageDeletedEvent.deletedThreadIds",
    "MozMessageDeletedEvent.isTrusted",
    "MozMmsEvent",
    "MozMmsEvent.isTrusted",
    "MozMmsEvent.message",
    "MozMobileConnection.changeCallBarringPassword",
    "MozMobileConnection.data",
    "MozMobileConnection.exitEmergencyCbMode",
    "MozMobileConnection.getCallBarringOption",
    "MozMobileConnection.getCallForwardingOption",
    "MozMobileConnection.getCallWaitingOption",
    "MozMobileConnection.getCallingLineIdRestriction",
    "MozMobileConnection.getNetworks",
    "MozMobileConnection.getPreferredNetworkType",
    "MozMobileConnection.getRoamingPreference",
    "MozMobileConnection.getVoicePrivacyMode",
    "MozMobileConnection.iccId",
    "MozMobileConnection.lastKnownHomeNetwork",
    "MozMobileConnection.lastKnownNetwork",
    "MozMobileConnection.networkSelectionMode",
    "MozMobileConnection.radioState",
    "MozMobileConnection.selectNetwork",
    "MozMobileConnection.selectNetworkAutomatically",
    "MozMobileConnection.setCallBarringOption",
    "MozMobileConnection.setCallForwardingOption",
    "MozMobileConnection.setCallWaitingOption",
    "MozMobileConnection.setCallingLineIdRestriction",
    "MozMobileConnection.setPreferredNetworkType",
    "MozMobileConnection.setRadioEnabled",
    "MozMobileConnection.setRoamingPreference",
    "MozMobileConnection.setVoicePrivacyMode",
    "MozMobileConnection.supportedNetworkTypes",
    "MozMobileConnection.voice",
    "MozMobileMessageManager",
    "MozMobileMessageManager.delete",
    "MozMobileMessageManager.getMessage",
    "MozMobileMessageManager.getMessages",
    "MozMobileMessageManager.getSegmentInfoForText",
    "MozMobileMessageManager.getSmscAddress",
    "MozMobileMessageManager.getThreads",
    "MozMobileMessageManager.markMessageRead",
    "MozMobileMessageManager.ondeleted",
    "MozMobileMessageManager.ondeliveryerror",
    "MozMobileMessageManager.ondeliverysuccess",
    "MozMobileMessageManager.onfailed",
    "MozMobileMessageManager.onreaderror",
    "MozMobileMessageManager.onreadsuccess",
    "MozMobileMessageManager.onreceived",
    "MozMobileMessageManager.onretrieving",
    "MozMobileMessageManager.onsending",
    "MozMobileMessageManager.onsent",
    "MozMobileMessageManager.retrieveMMS",
    "MozMobileMessageManager.send",
    "MozMobileMessageManager.sendMMS",
    "MozMobileMessageManager.setSmscAddress",
    "MozSettingsTransactionEvent",
    "MozSettingsTransactionEvent.error",
    "MozSettingsTransactionEvent.isTrusted",
    "MozSmsEvent",
    "MozSmsEvent.isTrusted",
    "MozSmsEvent.message",
    "MozStkCommandEvent",
    "MozStkCommandEvent.command",
    "MozStkCommandEvent.isTrusted",
    "MozVoicemail",
    "MozVoicemail.getDisplayName",
    "MozVoicemail.getNumber",
    "MozVoicemail.getStatus",
    "MozVoicemail.onstatuschanged",
    "MozVoicemailEvent",
    "MozVoicemailEvent.isTrusted",
    "MozVoicemailEvent.status",
    "MozVoicemailStatus",
    "MozVoicemailStatus.hasMessages",
    "MozVoicemailStatus.messageCount",
    "MozVoicemailStatus.returnMessage",
    "MozVoicemailStatus.returnNumber",
    "MozVoicemailStatus.serviceId",
    "Navigator.addIdleObserver",
    "Navigator.engineeringMode",
    "Navigator.getFeature",
    "Navigator.hasFeature",
    "Navigator.inputPortManager",
    "Navigator.mozAlarms",
    "Navigator.mozBrowserElementProxy",
    "Navigator.mozInputMethod",
    "Navigator.mozKillSwitch",
    "Navigator.mozPermissionSettings",
    "Navigator.mozPhoneNumberService",
    "Navigator.mozPower",
    "Navigator.mozPresentationDeviceInfo",
    "Navigator.mozTCPSocket",
    "Navigator.removeIdleObserver",
    "Navigator.seManager",
    "Navigator.syncManager",
    "Navigator.tv",
    "Navigator.updateManager",
    "NetworkStatsData",
    "NetworkStatsData.receivedBytes",
    "NetworkStatsData.sentBytes",
    "NetworkStatsData.timestamp",
    "PowerStatsData",
    "PowerStatsData.consumedPower",
    "PowerStatsData.timestamp",
    "PresentationRequest.startWithDevice",
    "RequestSyncApp",
    "RequestSyncApp.isInBrowserElement",
    "RequestSyncApp.manifestURL",
    "RequestSyncApp.origin",
    "RequestSyncTask",
    "RequestSyncTask.app",
    "RequestSyncTask.data",
    "RequestSyncTask.lastSync",
    "RequestSyncTask.minInterval",
    "RequestSyncTask.oneShot",
    "RequestSyncTask.overwrittenMinInterval",
    "RequestSyncTask.runNow",
    "RequestSyncTask.setPolicy",
    "RequestSyncTask.state",
    "RequestSyncTask.task",
    "RequestSyncTask.wakeUpPage",
    "RequestSyncTask.wifiOnly",
    "ResourceStats",
    "ResourceStats.component",
    "ResourceStats.end",
    "ResourceStats.getData",
    "ResourceStats.manifestURL",
    "ResourceStats.serviceType",
    "ResourceStats.start",
    "ResourceStats.type",
    "ResourceStatsAlarm",
    "ResourceStatsAlarm.alarmId",
    "ResourceStatsAlarm.component",
    "ResourceStatsAlarm.data",
    "ResourceStatsAlarm.manifestURL",
    "ResourceStatsAlarm.serviceType",
    "ResourceStatsAlarm.threshold",
    "ResourceStatsAlarm.type",
    "ResourceStatsManager",
    "ResourceStatsManager.addAlarm",
    "ResourceStatsManager.clearAllStats",
    "ResourceStatsManager.clearStats",
    "ResourceStatsManager.getAlarms",
    "ResourceStatsManager.getAvailableComponents",
    "ResourceStatsManager.getStats",
    "ResourceStatsManager.maxStorageAge",
    "ResourceStatsManager.removeAlarm",
    "ResourceStatsManager.removeAllAlarms",
    "ResourceStatsManager.resourceTypes",
    "ResourceStatsManager.sampleRate",
    "SEChannel",
    "SEChannel.close",
    "SEChannel.isClosed",
    "SEChannel.openResponse",
    "SEChannel.session",
    "SEChannel.transmit",
    "SEChannel.type",
    "SEReader",
    "SEReader.closeAll",
    "SEReader.isSEPresent",
    "SEReader.openSession",
    "SEReader.type",
    "SEResponse",
    "SEResponse.channel",
    "SEResponse.data",
    "SEResponse.sw1",
    "SEResponse.sw2",
    "SESession",
    "SESession.closeAll",
    "SESession.isClosed",
    "SESession.openLogicalChannel",
    "SESession.reader",
    "SmsMessage",
    "SmsMessage.body",
    "SmsMessage.delivery",
    "SmsMessage.deliveryStatus",
    "SmsMessage.deliveryTimestamp",
    "SmsMessage.iccId",
    "SmsMessage.id",
    "SmsMessage.messageClass",
    "SmsMessage.read",
    "SmsMessage.receiver",
    "SmsMessage.sender",
    "SmsMessage.sentTimestamp",
    "SmsMessage.threadId",
    "SmsMessage.timestamp",
    "SmsMessage.type",
    "SystemUpdateProvider",
    "SystemUpdateProvider.applyUpdate",
    "SystemUpdateProvider.checkForUpdate",
    "SystemUpdateProvider.getParameter",
    "SystemUpdateProvider.name",
    "SystemUpdateProvider.onerror",
    "SystemUpdateProvider.onprogress",
    "SystemUpdateProvider.onupdateavailable",
    "SystemUpdateProvider.onupdateready",
    "SystemUpdateProvider.setParameter",
    "SystemUpdateProvider.startDownload",
    "SystemUpdateProvider.stopDownload",
    "SystemUpdateProvider.uuid",
    "TVChannel",
    "TVChannel.getCurrentProgram",
    "TVChannel.getPrograms",
    "TVChannel.isEmergency",
    "TVChannel.isFree",
    "TVChannel.name",
    "TVChannel.networkId",
    "TVChannel.number",
    "TVChannel.serviceId",
    "TVChannel.source",
    "TVChannel.transportStreamId",
    "TVChannel.type",
    "TVCurrentChannelChangedEvent",
    "TVCurrentChannelChangedEvent.channel",
    "TVCurrentChannelChangedEvent.isTrusted",
    "TVCurrentSourceChangedEvent",
    "TVCurrentSourceChangedEvent.isTrusted",
    "TVCurrentSourceChangedEvent.source",
    "TVEITBroadcastedEvent",
    "TVEITBroadcastedEvent.isTrusted",
    "TVEITBroadcastedEvent.programs",
    "TVManager",
    "TVManager.getTuners",
    "TVProgram",
    "TVProgram.channel",
    "TVProgram.description",
    "TVProgram.duration",
    "TVProgram.eventId",
    "TVProgram.getAudioLanguages",
    "TVProgram.getSubtitleLanguages",
    "TVProgram.rating",
    "TVProgram.startTime",
    "TVProgram.title",
    "TVScanningStateChangedEvent",
    "TVScanningStateChangedEvent.channel",
    "TVScanningStateChangedEvent.isTrusted",
    "TVScanningStateChangedEvent.state",
    "TVSource",
    "TVSource.currentChannel",
    "TVSource.getChannels",
    "TVSource.isScanning",
    "TVSource.oncurrentchannelchanged",
    "TVSource.oneitbroadcasted",
    "TVSource.onscanningstatechanged",
    "TVSource.setCurrentChannel",
    "TVSource.startScanning",
    "TVSource.stopScanning",
    "TVSource.tuner",
    "TVSource.type",
    "TVTuner",
    "TVTuner.currentSource",
    "TVTuner.getSources",
    "TVTuner.getSupportedSourceTypes",
    "TVTuner.id",
    "TVTuner.oncurrentsourcechanged",
    "TVTuner.setCurrentSource",
    "TVTuner.stream",
    "Telephony.ownAudioChannel",
    "UDPMessageEvent",
    "UDPMessageEvent.data",
    "UDPMessageEvent.isTrusted",
    "UDPMessageEvent.remoteAddress",
    "UDPMessageEvent.remotePort",
    "UDPSocket",
    "UDPSocket.addressReuse",
    "UDPSocket.close",
    "UDPSocket.closed",
    "UDPSocket.joinMulticastGroup",
    "UDPSocket.leaveMulticastGroup",
    "UDPSocket.localAddress",
    "UDPSocket.localPort",
    "UDPSocket.loopback",
    "UDPSocket.onmessage",
    "UDPSocket.opened",
    "UDPSocket.readyState",
    "UDPSocket.remoteAddress",
    "UDPSocket.remotePort",
    "UDPSocket.send",
    "USSDReceivedEvent",
    "USSDReceivedEvent.isTrusted",
    "USSDReceivedEvent.message",
    "USSDReceivedEvent.serviceId",
    "USSDReceivedEvent.session",
    "USSDSession",
    "USSDSession.cancel",
    "USSDSession.send",
    nullptr
  };
  const char* const* feature = FeatureList;
  while (*feature) {
    if (aFeature.EqualsASCII(*feature)) {
      return true;
    }
    ++feature;
  }

  return false;
}
} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_FeatureList_h
