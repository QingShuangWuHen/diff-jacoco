package org.jacoco.core.data;

import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICounter;
import org.jacoco.core.analysis.IMethodCoverage;
import org.jacoco.core.internal.analysis.CounterImpl;

/**
 *
 * @author yanpengfang
 * create 2019-12-30 2:52 PM
 */
public class MethodCoverPair {
    private String methodName;
    private String md5;
    private IClassCoverage classCoverage;
    private IMethodCoverage methodCoverage;
    private double coverageRate;

    public MethodCoverPair(String methodName, String md5,
            IClassCoverage classCoverage, IMethodCoverage methodCoverage) {
        this.methodName = methodName;
        this.md5 = md5;
        this.classCoverage = classCoverage;
        this.methodCoverage = methodCoverage;
        this.coverageRate = methodCoverage.getMethodCounter().getCoveredRatio();
    }

    public IMethodCoverage getMethodCoverage() {
        return methodCoverage;
    }

    public void setMethodCoverage(IMethodCoverage methodCoverage) {
        this.methodCoverage = methodCoverage;
    }

    public IClassCoverage getClassCoverage() {
        return classCoverage;
    }

    public void setClassCoverage(IClassCoverage classCoverage) {
        this.classCoverage = classCoverage;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public double getCoverageRate() {
        return coverageRate;
    }

    public void setCoverageRate(double coverageRate) {
        this.coverageRate = coverageRate;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void updateCoverCounter() {
        ICounter classCounter = classCoverage.getInstructionCounter();
        if (classCounter instanceof CounterImpl) {
            ((CounterImpl) classCounter).updateCover(1);
        }
        ICounter methodCounter = methodCoverage.getInstructionCounter();
        if (methodCounter instanceof CounterImpl) {
            ((CounterImpl) methodCounter).updateCover(1);
        }
    }
}
