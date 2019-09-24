// Targeted by JavaCPP version 1.5.2-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.hdf5;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.hdf5.global.hdf5.*;


/** \class DataSet
    \brief Class DataSet operates on HDF5 datasets.
    <p>
    An datasets has many characteristics similar to an attribute, thus both
    Attribute and DataSet are derivatives of AbstractDs.  DataSet also
    inherits from H5Object because a dataset is an HDF5 object.
*/
//  Inheritance: multiple H5Object/AbstractDs -> H5Location -> IdComponent
@Namespace("H5") @NoOffset @Properties(inherit = org.bytedeco.hdf5.presets.hdf5.class)
public class DataSet extends H5Object {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DataSet(Pointer p) { super(p); }
    public AbstractDs asAbstractDs() { return asAbstractDs(this); }
    @Namespace public static native @Name("static_cast<H5::AbstractDs*>") AbstractDs asAbstractDs(DataSet pointer);


        // Close this dataset.
        public native @Name("close") void _close();

        // Extends the dataset with unlimited dimension.
        public native void extend(@Cast("const hsize_t*") LongPointer size);
        public native void extend(@Cast("const hsize_t*") LongBuffer size);
        public native void extend(@Cast("const hsize_t*") long[] size);

        // Fills a selection in memory with a value
        public native void fillMemBuf(@Const Pointer fill, @Const @ByRef DataType fill_type, Pointer buf, @Const @ByRef DataType buf_type, @Const @ByRef DataSpace space);
        //void fillMemBuf(const void *fill, DataType& fill_type, void *buf, DataType& buf_type, DataSpace& space); // removed from 1.8.18 and 1.10.1

        // Fills a selection in memory with zero
        public native void fillMemBuf(Pointer buf, @Const @ByRef DataType buf_type, @Const @ByRef DataSpace space);
        //void fillMemBuf(void *buf, DataType& buf_type, DataSpace& space); // removed from 1.8.18 and 1.10.1

        // Gets the creation property list of this dataset.
        public native @ByVal DSetCreatPropList getCreatePlist();

        // Gets the access property list of this dataset.
        public native @ByVal DSetAccPropList getAccessPlist();

        // Returns the address of this dataset in the file.
        public native @Cast("haddr_t") long getOffset();

        // Gets the dataspace of this dataset.
        public native @ByVal DataSpace getSpace();

        // Determines whether space has been allocated for a dataset.
        public native void getSpaceStatus(@Cast("H5D_space_status_t*") @ByRef IntPointer status);
        public native void getSpaceStatus(@Cast("H5D_space_status_t*") @ByRef IntBuffer status);
        public native void getSpaceStatus(@Cast("H5D_space_status_t*") @ByRef int[] status);

        // Returns the amount of storage size required for this dataset.
        public native @Cast("hsize_t") long getStorageSize();

        // Returns the in memory size of this attribute's data.
        public native @Cast("size_t") long getInMemDataSize();

        // Returns the number of bytes required to store VL data.
        public native @Cast("hsize_t") long getVlenBufSize(@Const @ByRef DataType type, @Const @ByRef DataSpace space);
        //hsize_t getVlenBufSize(DataType& type, DataSpace& space) const; // removed from 1.8.18 and 1.10.1

        // Reclaims VL datatype memory buffers.
        public static native void vlenReclaim(@Const @ByRef DataType type, @Const @ByRef DataSpace space, @Const @ByRef DSetMemXferPropList xfer_plist, Pointer buf);
        public static native void vlenReclaim(Pointer buf, @Const @ByRef DataType type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public static native void vlenReclaim(Pointer buf, @Const @ByRef DataType type);

        // Reads the data of this dataset and stores it in the provided buffer.
        // The memory and file dataspaces and the transferring property list
        // can be defaults.
        public native void read(Pointer buf, @Const @ByRef DataType mem_type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace mem_space, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace file_space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public native void read(Pointer buf, @Const @ByRef DataType mem_type);
        public native void read(@StdString @ByRef BytePointer buf, @Const @ByRef DataType mem_type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace mem_space, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace file_space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public native void read(@StdString @ByRef BytePointer buf, @Const @ByRef DataType mem_type);

        // Writes the buffered data to this dataset.
        // The memory and file dataspaces and the transferring property list
        // can be defaults.
        public native void write(@Const Pointer buf, @Const @ByRef DataType mem_type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace mem_space, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace file_space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public native void write(@Const Pointer buf, @Const @ByRef DataType mem_type);
        public native void write(@StdString BytePointer buf, @Const @ByRef DataType mem_type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace mem_space, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace file_space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public native void write(@StdString BytePointer buf, @Const @ByRef DataType mem_type);
        public native void write(@StdString String buf, @Const @ByRef DataType mem_type, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace mem_space, @Const @ByRef(nullValue = "H5::DataSpace::ALL") DataSpace file_space, @Const @ByRef(nullValue = "H5::DSetMemXferPropList::DEFAULT") DSetMemXferPropList xfer_plist);
        public native void write(@StdString String buf, @Const @ByRef DataType mem_type);

        // Iterates the selected elements in the specified dataspace - not implemented in C++ style yet
        public native int iterateElems(Pointer buf, @Const @ByRef DataType type, @Const @ByRef DataSpace space, H5D_operator_t op, Pointer op_data/*=NULL*/);
        public native int iterateElems(Pointer buf, @Const @ByRef DataType type, @Const @ByRef DataSpace space, H5D_operator_t op);

        /**\brief Returns this class name. */
        public native @StdString BytePointer fromClass();

        // Creates a dataset by way of dereference.
        public DataSet(@Const @ByRef H5Location loc, @Const Pointer ref, @Cast("H5R_type_t") int ref_type/*=H5R_OBJECT*/, @Const @ByRef(nullValue = "H5::PropList::DEFAULT") PropList plist) { super((Pointer)null); allocate(loc, ref, ref_type, plist); }
        private native void allocate(@Const @ByRef H5Location loc, @Const Pointer ref, @Cast("H5R_type_t") int ref_type/*=H5R_OBJECT*/, @Const @ByRef(nullValue = "H5::PropList::DEFAULT") PropList plist);
        public DataSet(@Const @ByRef H5Location loc, @Const Pointer ref) { super((Pointer)null); allocate(loc, ref); }
        private native void allocate(@Const @ByRef H5Location loc, @Const Pointer ref);
        public DataSet(@Const @ByRef Attribute attr, @Const Pointer ref, @Cast("H5R_type_t") int ref_type/*=H5R_OBJECT*/, @Const @ByRef(nullValue = "H5::PropList::DEFAULT") PropList plist) { super((Pointer)null); allocate(attr, ref, ref_type, plist); }
        private native void allocate(@Const @ByRef Attribute attr, @Const Pointer ref, @Cast("H5R_type_t") int ref_type/*=H5R_OBJECT*/, @Const @ByRef(nullValue = "H5::PropList::DEFAULT") PropList plist);
        public DataSet(@Const @ByRef Attribute attr, @Const Pointer ref) { super((Pointer)null); allocate(attr, ref); }
        private native void allocate(@Const @ByRef Attribute attr, @Const Pointer ref);

        // Default constructor.
        public DataSet() { super((Pointer)null); allocate(); }
        private native void allocate();

        // Copy constructor - same as the original DataSet.
        public DataSet(@Const @ByRef DataSet original) { super((Pointer)null); allocate(original); }
        private native void allocate(@Const @ByRef DataSet original);

        // Creates a copy of an existing DataSet using its id.
        public DataSet(@Cast("const hid_t") long existing_id) { super((Pointer)null); allocate(existing_id); }
        private native void allocate(@Cast("const hid_t") long existing_id);

        // Gets the dataset id.
        public native @Cast("hid_t") long getId();

        // Destructor: properly terminates access to this dataset.

}
