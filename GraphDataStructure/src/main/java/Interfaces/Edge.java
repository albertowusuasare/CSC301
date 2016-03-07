package Interfaces;

/**
 * Created by albertowusu-asare on 3/7/16.
 */
public interface Edge <W> {
    W getWeight();
    @Override
    int hashCode();
}
