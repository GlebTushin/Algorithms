class BellmanFord
{
    private int distances[];
    private int numberofverticles;

    public static final int MAX_VALUE = 999;

    public BellmanFord(int numberofverticles)
    {
        this.numberofverticles = numberofverticles;
        distances = new int[numberofverticles + 1];
    }

    public void BellmanFordEvaluation(int source, int matrix[][])
    {
        for (int node = 0; node <= numberofverticles; node++)
        {
            distances[node] = MAX_VALUE;
        }

        distances[source] = 0;

        for (int node = 0; node <= numberofverticles-1; node++)
        {
            for (int i = 0; i < numberofverticles; i++)
            {
                for (int destination = 0; destination < numberofverticles; destination++)
                {
                    if (matrix[i][destination] != MAX_VALUE)
                    {
                        if (distances[destination] > distances[i]
                                + matrix[i][destination])
                        {
                            distances[destination] = distances[i]
                                    + matrix[i][destination];
                        }
                    }
                }
            }
        }

        for (int sourcen = 0; sourcen <= numberofverticles-1; sourcen++)
        {
            for (int destination = 0; destination < numberofverticles; destination++)
            {
                if (matrix[sourcen][destination] != MAX_VALUE)
                {
                    if (distances[destination] > distances[sourcen]
                            + matrix[sourcen][destination])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
    }

    public int[] getDistances()
    {
        return distances;
    }
}