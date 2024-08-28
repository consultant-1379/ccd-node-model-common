/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2018
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/

package com.ericsson.oss.mediation.model.ci.ecee;

import com.ericsson.mediation.model.ci.ConnectivityInformation_100;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.AttributeChangeEventHandling;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.CommonChangeEventBehavior;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.Hierarchical;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.OnReadWrite;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.PrimaryTypeAttribute;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.PrimaryTypeChangeEventBehavior;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.PrimaryTypeChangeEventHandling;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.PrimaryTypeDefinition;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.ReadBehavior;
import com.ericsson.oss.itpf.datalayer.dps.modeling.annotation.WriteBehavior;
import com.ericsson.oss.itpf.modeling.annotation.DefaultValue;
import com.ericsson.oss.itpf.modeling.annotation.EModel;
import com.ericsson.oss.itpf.modeling.annotation.EModelAttribute;
import com.ericsson.oss.itpf.modeling.annotation.IpAddress;
import com.ericsson.oss.itpf.modeling.annotation.constraints.NotNull;
import com.ericsson.oss.mediation.model.ci.com.SnmpSecurityLevelType_100;
import com.ericsson.oss.mediation.model.ci.com.SnmpVersion_100;
import com.ericsson.oss.mediation.model.ci.com.TransportProtocolType_100;

@PrimaryTypeChangeEventHandling(onCreatePo = { PrimaryTypeChangeEventBehavior.NAMES, PrimaryTypeChangeEventBehavior.VALUES }, onDeletePo = {
    PrimaryTypeChangeEventBehavior.NAMES, PrimaryTypeChangeEventBehavior.VALUES })
@EModel(description = "This MO encapsulates all the 'common' connectivity attributes for the CCD traffic platform.",
        name = "CcdConnectivityInformation", namespace = "CCD_MED", version = "1.0.0")
@PrimaryTypeDefinition
@Hierarchical(parentMoTypeUrn = "//OSS_NE_DEF/CloudInfrastructureManager/*")
@OnReadWrite(onRead = ReadBehavior.READ_FROM_PERSISTENT_STORAGE, onWrite = WriteBehavior.WRITE_TO_DELEGATE)
public class CcdConnectivityInformation_100 extends ConnectivityInformation_100 {

    @PrimaryTypeAttribute
    @EModelAttribute(description = "The unique key identifying this particular MO", key = true, immutable = true, mandatory = true)
    @NotNull
    private String CcdConnectivityInformationId;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "The IP address", mandatory = true)
    @IpAddress
    @NotNull
    @AttributeChangeEventHandling(onModifyAttr = { CommonChangeEventBehavior.VALUE })
    private String ipAddress;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "The Http port", mandatory = false)
    @DefaultValue(value = "9093")
    private int port;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Enable Https over Secure Socket")
    @DefaultValue("false")
    public boolean secure;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Snmp version", mandatory = false)
    @DefaultValue(value = "SNMP_V2C")
    private SnmpVersion_100 snmpVersion;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Snmp security name for SNMP protocol", mandatory = false)
    private String snmpSecurityName;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Community string for Snmp SET management", mandatory = false)
    @DefaultValue(value = "public")
    private String snmpWriteCommunity;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Community string for Snmp GET management", mandatory = false)
    @DefaultValue(value = "public")
    private String snmpReadCommunity;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "Security level for SNMP protocol", mandatory = false)
    private SnmpSecurityLevelType_100 snmpSecurityLevel;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "The Snmp Agent port", mandatory = false)
    @DefaultValue(value = "161")
    private String snmpAgentPort;

    @PrimaryTypeAttribute
    @EModelAttribute(description = "The Snmp Agent port", mandatory = false)
    @DefaultValue(value = "162")
    private String snmpTrapPort;
}