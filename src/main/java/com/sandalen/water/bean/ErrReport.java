package com.sandalen.water.bean;

public class ErrReport {
    private Integer id;

    private String reportId;

    private String result;

    private String basinError;

    private String enterpriseError;

    private String factorResult;

    private String factorSolution;

    private String sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getBasinError() {
        return basinError;
    }

    public void setBasinError(String basinError) {
        this.basinError = basinError == null ? null : basinError.trim();
    }

    public String getEnterpriseError() {
        return enterpriseError;
    }

    public void setEnterpriseError(String enterpriseError) {
        this.enterpriseError = enterpriseError == null ? null : enterpriseError.trim();
    }

    public String getFactorResult() {
        return factorResult;
    }

    public void setFactorResult(String factorResult) {
        this.factorResult = factorResult == null ? null : factorResult.trim();
    }

    public String getFactorSolution() {
        return factorSolution;
    }

    public void setFactorSolution(String factorSolution) {
        this.factorSolution = factorSolution == null ? null : factorSolution.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }
}