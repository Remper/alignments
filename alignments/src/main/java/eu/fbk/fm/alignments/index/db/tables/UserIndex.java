/**
 * This class is generated by jOOQ
 */
package eu.fbk.fm.alignments.index.db.tables;


import eu.fbk.fm.alignments.index.db.Public;
import eu.fbk.fm.alignments.index.db.tables.records.UserIndexRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserIndex extends TableImpl<UserIndexRecord> {

    private static final long serialVersionUID = -486765049;

    /**
     * The reference instance of <code>public.user_index</code>
     */
    public static final UserIndex USER_INDEX = new UserIndex();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserIndexRecord> getRecordType() {
        return UserIndexRecord.class;
    }

    /**
     * The column <code>public.user_index.fullname</code>.
     */
    public final TableField<UserIndexRecord, String> FULLNAME = createField("fullname", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.user_index.uid</code>.
     */
    public final TableField<UserIndexRecord, Long> UID = createField("uid", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_index.freq</code>.
     */
    public final TableField<UserIndexRecord, Integer> FREQ = createField("freq", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.user_index</code> table reference
     */
    public UserIndex() {
        this("user_index", null);
    }

    /**
     * Create an aliased <code>public.user_index</code> table reference
     */
    public UserIndex(String alias) {
        this(alias, USER_INDEX);
    }

    private UserIndex(String alias, Table<UserIndexRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserIndex(String alias, Table<UserIndexRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserIndex as(String alias) {
        return new UserIndex(alias, this);
    }

    /**
     * Rename this table
     */
    public UserIndex rename(String name) {
        return new UserIndex(name, null);
    }
}
