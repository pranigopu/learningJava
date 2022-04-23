enum TopSpeeds
{
    buggati_veyron(407),
    lamborghini_aventador(349),
    ferrari_enzo(355),
    lotus_evija(320);
    int topSpeed;
    private TopSpeeds(int topSpeed)
    {
        this.topSpeed = topSpeed;
    }
}
class CarTopSpeeds
{
    public static void main(String args[])
    {
        TopSpeeds[] ts = TopSpeeds.values();
        System.out.println(ts[0] + ": " + ts[0].topSpeed);
        System.out.println(ts[1] + ": " + ts[1].topSpeed);
        System.out.println(ts[2] + ": " + ts[2].topSpeed);
        System.out.println(ts[3] + ": " + ts[3].topSpeed);
    }
}