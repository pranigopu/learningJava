enum FastCars
{
    buggati_veyron,
    lamborghini_aventador,
    ferrari_enzo,
    lotus_evija;
}
class SimpleEnumDemo
{
    public static void main(String args[])
    {
        FastCars fastCar;
        fastCar = FastCars.buggati_veyron;
        System.out.println(fastCar + " is a fast car.");
    }
}