
public class Date implements Comparable<Date>{
    private int jj;
    private int mm;
    private int aaaa;

    public Date(int jour, int mois, int année){
        if(validate(jour, 1, 31)){this.jj = jour;}

        if(validate(mois, 1, 12)){this.mm = mois;}
        
        if(validate(année, 0, année+1)){this.aaaa = année;}
    }
    public boolean validate(int value, int min, int max){
        if(min<value && max>value){
            return true;
        }
        return false;
    }

    public String toString(Object Date){
        return String.format("0.2%d/%d/%d", this.jj, this.mm, this.aaaa);
    }
    
    public int compareTo(Date other){
        if(this.aaaa == other.aaaa){
            if(this.mm == other.mm){
                if(this.jj == other.jj){return 0;}
                if(this.jj < other.jj){return -1;}
                if(this.jj > other.jj){return 1;}
            }
            else if(this.mm < other.mm){return -1;}
            else if(this.mm > other.mm){return 1;}
        }
        else if(this.aaaa < other.aaaa){return -1;}
        else if(this.aaaa > other.aaaa){return 1;}
        return -4;
    }
}

