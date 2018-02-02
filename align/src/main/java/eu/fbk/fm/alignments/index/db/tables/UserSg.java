/**
 * This class is generated by jOOQ
 */
package eu.fbk.fm.alignments.index.db.tables;


import eu.fbk.fm.alignments.index.db.Public;
import eu.fbk.fm.alignments.index.db.tables.records.UserSgRecord;

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
public class UserSg extends TableImpl<UserSgRecord> {

    private static final long serialVersionUID = -1823883885;

    /**
     * The reference instance of <code>public.user_sg</code>
     */
    public static final UserSg USER_SG = new UserSg();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserSgRecord> getRecordType() {
        return UserSgRecord.class;
    }

    /**
     * The column <code>public.user_sg.uid</code>.
     */
    public final TableField<UserSgRecord, Long> UID = createField("uid", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_sg.followees</code>.
     */
    public final TableField<UserSgRecord, Long[]> FOLLOWEES = createField("followees", org.jooq.impl.SQLDataType.BIGINT.getArrayDataType(), this, "");

    /**
     * The column <code>public.user_sg.weights</code>.
     */
    public final TableField<UserSgRecord, Float[]> WEIGHTS = createField("weights", org.jooq.impl.SQLDataType.REAL.getArrayDataType(), this, "");

    /**
     * Create a <code>public.user_sg</code> table reference
     */
    public UserSg() {
        this("user_sg", null);
    }

    /**
     * Create an aliased <code>public.user_sg</code> table reference
     */
    public UserSg(String alias) {
        this(alias, USER_SG);
    }

    private UserSg(String alias, Table<UserSgRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserSg(String alias, Table<UserSgRecord> aliased, Field<?>[] parameters) {
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
    public UserSg as(String alias) {
        return new UserSg(alias, this);
    }

    /**
     * Rename this table
     */
    public UserSg rename(String name) {
        return new UserSg(name, null);
    }
}
