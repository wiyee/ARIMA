package arima;

import java.util.*;

public class AR {

    private double[] stdoriginalData = {};
    private int p;
    ARMAMath armamath = new ARMAMath();

    /**
     * ARģ��
     *
     * @param stdoriginalData
     * @param p               //pΪMAģ�ͽ���
     */
    public AR(double[] stdoriginalData, int p) {
        this.stdoriginalData = stdoriginalData;
        this.p = p;
    }

    /**
     * ����ARģ�Ͳ���
     *
     * @return
     */
    public Vector<double[]> ARmodel() {
        Vector<double[]> v = new Vector<double[]>();
        v.add(armamath.parcorrCompute(stdoriginalData, p, 0));
        return v;//�õ����Իع�ϵ��

        //��Ҫ���Ʒ�������
    }

}
