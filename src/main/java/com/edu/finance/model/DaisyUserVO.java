package com.edu.finance.model;

import java.io.Serializable;

import javax.persistence.Transient;

public class DaisyUserVO implements Serializable {
    private Long id;

    private String sCode;

    private String sName;

    private String sPwd;

    private String sAccessKey;

    private String sEmail;

    private String sPhone;

    private String sTenantCode;

    private int iType;

    private int iStatus;

    private String sCreateTime;
    
    private String sUpdateTime;

    private String sOpenTime;
    
    private int iConcernLimit;
    
    private int iQueryLimit;
    
    private String altNoticeEmail;//变更通知收件人
    
    @Transient
    private String sTenantName;
    
    @Transient
    private String captcha;
    
    @Transient
    private String context;
    
    private int accessType;//1测试用户  2正式用户
    
    private int debugCallNum;
    
    private String ownProject;
    
    /**
     * 缓存的目的
     */
    @Transient
    private String cacheReason;
    
    // 预置关心的企业
    private String presetConcernEnt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd == null ? null : sPwd.trim();
    }

    public String getsAccessKey() {
        return sAccessKey;
    }

    public void setsAccessKey(String sAccessKey) {
        this.sAccessKey = sAccessKey == null ? null : sAccessKey.trim();
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail == null ? null : sEmail.trim();
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone == null ? null : sPhone.trim();
    }

    public String getsTenantCode() {
        return sTenantCode;
    }

    public void setsTenantCode(String sTenantCode) {
        this.sTenantCode = sTenantCode == null ? null : sTenantCode.trim();
    }

    public int getiType() {
        return iType;
    }

    public void setiType(int iType) {
        this.iType = iType;
    }

    public int getiStatus() {
        return iStatus;
    }

    public void setiStatus(int iStatus) {
        this.iStatus = iStatus;
    }

    public String getsCreateTime() {
        return sCreateTime;
    }

    public void setsCreateTime(String sCreateTime) {
        this.sCreateTime = sCreateTime == null ? null : sCreateTime.trim();
    }

    public String getsOpenTime() {
        return sOpenTime;
    }

    public void setsOpenTime(String sOpenTime) {
        this.sOpenTime = sOpenTime == null ? null : sOpenTime.trim();
    }

	public String getsTenantName() {
		return sTenantName;
	}

	public void setsTenantName(String sTenantName) {
		this.sTenantName = sTenantName;
	}

	public String getsUpdateTime() {
		return sUpdateTime;
	}

	public void setsUpdateTime(String sUpdateTime) {
		this.sUpdateTime = sUpdateTime;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getCacheReason() {
		return cacheReason;
	}

	public void setCacheReason(String cacheReason) {
		this.cacheReason = cacheReason;
	}

	public int getiConcernLimit() {
		return iConcernLimit;
	}

	public void setiConcernLimit(int iConcernLimit) {
		this.iConcernLimit = iConcernLimit;
	}

	public int getiQueryLimit() {
		return iQueryLimit;
	}

	public void setiQueryLimit(int iQueryLimit) {
		this.iQueryLimit = iQueryLimit;
	}

	public String getAltNoticeEmail() {
		return altNoticeEmail;
	}

	public void setAltNoticeEmail(String altNoticeEmail) {
		this.altNoticeEmail = altNoticeEmail;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	public int getDebugCallNum() {
		return debugCallNum;
	}

	public void setDebugCallNum(int debugCallNum) {
		this.debugCallNum = debugCallNum;
	}

	public String getOwnProject() {
		return ownProject;
	}

	public void setOwnProject(String ownProject) {
		this.ownProject = ownProject;
	}

	public String getPresetConcernEnt() {
		return presetConcernEnt;
	}

	public void setPresetConcernEnt(String presetConcernEnt) {
		this.presetConcernEnt = presetConcernEnt;
	}
}