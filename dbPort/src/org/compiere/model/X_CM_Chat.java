/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                        *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software;
 you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program;
 if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

/** Generated Model - DO NOT CHANGE */
import java.util.*;
import java.sql.*;
import java.math.*;
import org.compiere.util.*;
/** Generated Model for CM_Chat
 *  @author Jorg Janke (generated) 
 *  @version Release 2.5.3d - 2006-10-10 21:55:55.718 */
public class X_CM_Chat extends PO
{
/** Standard Constructor
@param ctx context
@param CM_Chat_ID id
@param trxName transaction
*/
public X_CM_Chat (Properties ctx, int CM_Chat_ID, String trxName)
{
super (ctx, CM_Chat_ID, trxName);
/** if (CM_Chat_ID == 0)
{
setAD_Table_ID (0);
setCM_Chat_ID (0);
setConfidentialType (null);
setDescription (null);
setRecord_ID (0);
}
 */
}
/** Load Constructor 
@param ctx context
@param rs result set 
@param trxName transaction
*/
public X_CM_Chat (Properties ctx, ResultSet rs, String trxName)
{
super (ctx, rs, trxName);
}
/** AD_Table_ID=876 */
public static final int Table_ID=876;

/** TableName=CM_Chat */
public static final String Table_Name="CM_Chat";

protected static KeyNamePair Model = new KeyNamePair(876,"CM_Chat");

protected BigDecimal accessLevel = new BigDecimal(7);
/** AccessLevel
@return 7 - System - Client - Org 
*/
protected int get_AccessLevel()
{
return accessLevel.intValue();
}
/** Load Meta Data
@param ctx context
@return PO Info
*/
protected POInfo initPO (Properties ctx)
{
POInfo poi = POInfo.getPOInfo (ctx, Table_ID);
return poi;
}
/** Info
@return info
*/
public String toString()
{
StringBuffer sb = new StringBuffer ("X_CM_Chat[").append(get_ID()).append("]");
return sb.toString();
}
/** Set Table.
@param AD_Table_ID Database Table information */
public void setAD_Table_ID (int AD_Table_ID)
{
if (AD_Table_ID < 1) throw new IllegalArgumentException ("AD_Table_ID is mandatory.");
set_ValueNoCheck ("AD_Table_ID", new Integer(AD_Table_ID));
}
/** Get Table.
@return Database Table information */
public int getAD_Table_ID() 
{
Integer ii = (Integer)get_Value("AD_Table_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set Chat Type.
@param CM_ChatType_ID Type of discussion / chat */
public void setCM_ChatType_ID (int CM_ChatType_ID)
{
if (CM_ChatType_ID <= 0) set_Value ("CM_ChatType_ID", null);
 else 
set_Value ("CM_ChatType_ID", new Integer(CM_ChatType_ID));
}
/** Get Chat Type.
@return Type of discussion / chat */
public int getCM_ChatType_ID() 
{
Integer ii = (Integer)get_Value("CM_ChatType_ID");
if (ii == null) return 0;
return ii.intValue();
}
/** Set Chat.
@param CM_Chat_ID Chat or discussion thread */
public void setCM_Chat_ID (int CM_Chat_ID)
{
if (CM_Chat_ID < 1) throw new IllegalArgumentException ("CM_Chat_ID is mandatory.");
set_ValueNoCheck ("CM_Chat_ID", new Integer(CM_Chat_ID));
}
/** Get Chat.
@return Chat or discussion thread */
public int getCM_Chat_ID() 
{
Integer ii = (Integer)get_Value("CM_Chat_ID");
if (ii == null) return 0;
return ii.intValue();
}

/** ConfidentialType AD_Reference_ID=340 */
public static final int CONFIDENTIALTYPE_AD_Reference_ID=340;
/** Public Information = A */
public static final String CONFIDENTIALTYPE_PublicInformation = "A";
/** Partner Confidential = C */
public static final String CONFIDENTIALTYPE_PartnerConfidential = "C";
/** Internal = I */
public static final String CONFIDENTIALTYPE_Internal = "I";
/** Private Information = P */
public static final String CONFIDENTIALTYPE_PrivateInformation = "P";
/** Set Confidentiality.
@param ConfidentialType Type of Confidentiality */
public void setConfidentialType (String ConfidentialType)
{
if (ConfidentialType == null) throw new IllegalArgumentException ("ConfidentialType is mandatory");
if (ConfidentialType.equals("A") || ConfidentialType.equals("C") || ConfidentialType.equals("I") || ConfidentialType.equals("P"));
 else throw new IllegalArgumentException ("ConfidentialType Invalid value - " + ConfidentialType + " - Reference_ID=340 - A - C - I - P");
if (ConfidentialType.length() > 1)
{
log.warning("Length > 1 - truncated");
ConfidentialType = ConfidentialType.substring(0,0);
}
set_Value ("ConfidentialType", ConfidentialType);
}
/** Get Confidentiality.
@return Type of Confidentiality */
public String getConfidentialType() 
{
return (String)get_Value("ConfidentialType");
}
/** Set Description.
@param Description Optional short description of the record */
public void setDescription (String Description)
{
if (Description == null) throw new IllegalArgumentException ("Description is mandatory.");
if (Description.length() > 255)
{
log.warning("Length > 255 - truncated");
Description = Description.substring(0,254);
}
set_Value ("Description", Description);
}
/** Get Description.
@return Optional short description of the record */
public String getDescription() 
{
return (String)get_Value("Description");
}
/** Get Record ID/ColumnName
@return ID/ColumnName pair
*/public KeyNamePair getKeyNamePair() 
{
return new KeyNamePair(get_ID(), getDescription());
}
/** Set Record ID.
@param Record_ID Direct internal record ID */
public void setRecord_ID (int Record_ID)
{
if (Record_ID < 0) throw new IllegalArgumentException ("Record_ID is mandatory.");
set_ValueNoCheck ("Record_ID", new Integer(Record_ID));
}
/** Get Record ID.
@return Direct internal record ID */
public int getRecord_ID() 
{
Integer ii = (Integer)get_Value("Record_ID");
if (ii == null) return 0;
return ii.intValue();
}
}
