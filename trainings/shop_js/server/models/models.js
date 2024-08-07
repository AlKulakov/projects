const sequelize = require('../db')
const {datatypes, DataTypes} = require('sequelize')

const User = sequelize.define( 'user',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        email: {type: DataTypes.STRING, unique: true, allowNull: false},
        password: {type: DataTypes.STRING, allowNull: false},
        role: {type: DataTypes.STRING, defaultValue: "USER", allowNull: false}
    }
)

const Basket = sequelize.define( 'basket',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
    }
)
const BasketDevice = sequelize.define( 'basket_device',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
    }
)
const Device = sequelize.define( 'device',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        name: {type: DataTypes.STRING, unique: true, allowNull: false},
        price: {type: DataTypes.DOUBLE, allowNull: false},
        rating: {type: DataTypes.DOUBLE, defaultValue: 0},
        img: {type: DataTypes.STRING, allowNull: false}
    }
)
const Brand = sequelize.define( 'brand',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        name: {type: DataTypes.STRING, unique: true, allowNull: false}
    }
)
const Type = sequelize.define( 'type',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        name: {type: DataTypes.STRING, unique: true, allowNull: false}
    }
)
const Rating = sequelize.define('rating',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        rating: {type: DataTypes.DOUBLE, defaultValue: 0, allowNull: false}
    })

const DeviceInfo = sequelize.define( 'device_info',
    {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true},
        title: {type: DataTypes.STRING, allowNull: false},
        description: {type: DataTypes.STRING, allowNull: false}
    }
)

const TypeBrand = sequelize.define('type_brand', {
        id: {type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true}
    }
)

User.hasOne(Basket);
Basket.belongsTo(User);

User.hasMany(Rating);
Rating.belongsTo(User);

Basket.hasMany(BasketDevice);
BasketDevice.belongsTo(Basket);
BasketDevice.belongsTo(Device);
Device.hasMany(BasketDevice);

Device.hasMany(DeviceInfo, {as: "info"});
DeviceInfo.belongsTo(Device);

Type.hasMany(Device);
Device.belongsTo(Type);

Brand.hasMany(Device);
Device.belongsTo(Brand);

Brand.belongsToMany(Type, {through: TypeBrand});
Type.belongsToMany(Brand, {through: TypeBrand});

module.exports = {
    User, Basket, BasketDevice, Device,  Type, Brand, Rating, TypeBrand, DeviceInfo
}