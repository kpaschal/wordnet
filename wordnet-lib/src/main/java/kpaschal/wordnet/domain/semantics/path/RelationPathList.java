package kpaschal.wordnet.domain.semantics.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author
 */
public class RelationPathList extends ArrayList<IRelationPath> {

    public RelationPathList() {
        super();
    }

    public RelationPathList(IRelationPath path) {
        super();
        super.add(path);
    }

    public static IRelationPath getShortestPath(RelationPathList pathList) {
        if (pathList.isEmpty()) {
            return new RelationPath();
        }
        List l = (List<IRelationPath>) pathList;
        Collections.sort(l);
        return (IRelationPath) l.get(0);
    }
}
