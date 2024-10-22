package src;

public class Player {
    

    private String _name;
    private int _points;

    //public Player(String name) {
	//	this._name = name;
     //   this._points = 0;
	//}

    // Update the player points, can take a negative value to remove points
    public void SetPoints(int addedPoints) {
        _points += addedPoints;
    }

    public void SetName(String name) {
        _name = name;
    }

    public int GetPoints() {
        return _points;
    }

    public String GetName(){
        return _name;
    }
    public Boolean hasWon(){
        if (GetPoints() >= 40){
            return true;
        }
        else{
            return false;
        }
    }
}
