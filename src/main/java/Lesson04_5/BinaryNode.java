package Lesson04_5;

public class BinaryNode<V> {
    public V Value;
    public BinaryNode<V> LeftChild, RightChild;

    public BinaryNode(V value) {
        Value = value;
    }
    public void AddNode(V value)
    {

        // проверяем значение меньше чем наше
        if ((Integer)value <(Integer) Value)
        {

            // если меньше добавляем в левое под дерево.
            if (LeftChild != null) LeftChild.AddNode(value);
            else
            {

                // добавляем нового ребенка
                BinaryNode<V> child = new BinaryNode(value);
                this.LeftChild = child;

            }
        }
        else
        {

            // если не меньше добавляем направо
            if (RightChild != null) RightChild.AddNode(value);
            else
            {

                // добавляем нового ребенка
                BinaryNode<V> child = new BinaryNode(value);
                this.RightChild = child;

            }
        }
    }

    public V FindNode(V target){
        if(target.equals(Value)) {
            return  Value;
        }
        // левая ветка
        if((Integer)target < (Integer)Value){
            if (LeftChild == null){
                return null;
            }
            return LeftChild.FindNode(target);
        }else{
            if (RightChild == null){
                return null;
            }
            return RightChild.FindNode(target);
        }

    }


}
