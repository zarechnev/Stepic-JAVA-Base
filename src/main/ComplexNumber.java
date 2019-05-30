public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object second){
        if (this == second){ return true; }
        if (second == null){ return false; }
        if (this.getClass() != second.getClass()){ return false; }

        if (this.getRe() == ((ComplexNumber) second).getRe() && this.getIm() == ((ComplexNumber) second).getIm()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (Double.hashCode(Double.hashCode(this.getIm()) + Double.hashCode(this.getRe())));
    }
}