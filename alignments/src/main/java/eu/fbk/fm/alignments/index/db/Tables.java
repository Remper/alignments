/**
 * This class is generated by jOOQ
 */
package eu.fbk.fm.alignments.index.db;


import eu.fbk.fm.alignments.index.db.tables.Alignments;
import eu.fbk.fm.alignments.index.db.tables.UserIndex;
import eu.fbk.fm.alignments.index.db.tables.UserObjects;
import eu.fbk.fm.alignments.index.db.tables.UserSg;
import eu.fbk.fm.alignments.index.db.tables.UserText;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.alignments</code>.
     */
    public static final Alignments ALIGNMENTS = eu.fbk.fm.alignments.index.db.tables.Alignments.ALIGNMENTS;

    /**
     * The table <code>public.user_index</code>.
     */
    public static final UserIndex USER_INDEX = eu.fbk.fm.alignments.index.db.tables.UserIndex.USER_INDEX;

    /**
     * The table <code>public.user_objects</code>.
     */
    public static final UserObjects USER_OBJECTS = eu.fbk.fm.alignments.index.db.tables.UserObjects.USER_OBJECTS;

    /**
     * The table <code>public.user_sg</code>.
     */
    public static final UserSg USER_SG = eu.fbk.fm.alignments.index.db.tables.UserSg.USER_SG;

    /**
     * The table <code>public.user_text</code>.
     */
    public static final UserText USER_TEXT = eu.fbk.fm.alignments.index.db.tables.UserText.USER_TEXT;
}
