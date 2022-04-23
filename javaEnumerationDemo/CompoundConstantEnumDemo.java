enum SpeciesMaxInfo
{
    tiger(120, 360, 25),
    lion(120, 250, 30),
    wolf(81, 79, 17);
    float maxHeight, maxWeight, maxAge;
    private SpeciesMaxInfo(float maxHeight, float maxWeight, float maxAge)
    {
        this.maxHeight = maxHeight;
        this.maxWeight = maxWeight;
        this.maxAge = maxAge;
    }
}
class CompoundConstantEnumDemo
{
    public static void main(String args[])
    {
        SpeciesMaxInfo info = SpeciesMaxInfo.tiger;
        System.out.println(info.maxHeight + ", " + info.maxWeight + ", " + info.maxAge);
    }
}